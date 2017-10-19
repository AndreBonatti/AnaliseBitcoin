package Iniciacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import sun.security.krb5.internal.Ticket;

import Model_Json.Exchange;
import Model_Json.Order_Book_Stats;
import Model_Json.Ticker;
import Model_Json.Total;
import Model_Json.Totalizadores;
import Util.Corretora_Enum;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.wsdl.util.IOUtils;

@SuppressWarnings("unused")
public class TESTEs {

	private static Gson gson = new Gson();
	private static HashMap<String, Exchange> exchange_Info;
	private static HashMap<String, Order_Book_Stats> order_book_stats_Info;
	private static JsonObject ticker_Info;

	private static Double precoTransacaoBTC = 0.00045; // 0,00045 $7,99 *http://bitcoinfees.21.co/api *https://blockchain.info/api

	public static void main(String[] args) throws Exception {

		// http://api.bitvalor.com/v1/exchanges.json
		exchange_Info = getExchange("exchanges.json");
		// http://api.bitvalor.com/v1/ticker.json
		ticker_Info = getTicker("ticker.json");
		// "http://api.bitvalor.com/v1/order_book_stats.json"
		order_book_stats_Info = getOrder_book_stats("order_book_stats.json");

		// Análise menor preço de compra
		menorPrecoCompraReais(10000.0);
//		maiorPrecoVendaBTC(Corretora_Enum.FOX.getCodigo(), 0.5);
	}

	private static void menorPrecoCompraReais(Double valor){
		List<Corretora_Enum> lista = (List<Corretora_Enum>) Arrays.asList(Corretora_Enum.values());

		HashMap<String, Double> melhor_negocio = new HashMap<>();
		for (Corretora_Enum corretora : lista) {

			Exchange exchange = exchange_Info.get(corretora.getCodigo());
			Order_Book_Stats order_book_stats = order_book_stats_Info.get(corretora.getCodigo());

			Double entrada_corretora = 0.0;
			entrada_corretora += valor * exchange.getFees().getInBRL().get(0); // %
			entrada_corretora += exchange.getFees().getInBRL().get(1); // reais

			Double dinheiro_corretora = 0.0;
			dinheiro_corretora = (valor - entrada_corretora);

			// TAXA CORRETORA
			System.out.println("Corretora " + corretora.getNome());
			System.out.println("Capital inicial $ " + valor);
			System.out.println("Taxas Ent. $ " + entrada_corretora + " ");
			System.out.println("Dinheiro corretora " + dinheiro_corretora);
			
			// TAXA TRANSAÇÃO COMPRA CORRETORA
			Double taxa_compra_ativa = 0.0;
			Double taxa_compra_passiva = 0.0;
			taxa_compra_passiva += dinheiro_corretora * exchange.getFees().getTradeBook().get(0); // %
			taxa_compra_ativa += dinheiro_corretora * exchange.getFees().getTradeMarket().get(0); // %

			try {
				Double valor_btc_Compra = Double.parseDouble(order_book_stats.getBid());
				System.out.println("valor_btc_Compra " + valor_btc_Compra);
				System.out.println("taxa_compra_passiva " + taxa_compra_passiva);
				System.out.println("taxa_compra_ativa " + taxa_compra_ativa);

				Double total_passivo = (dinheiro_corretora - taxa_compra_passiva);
				Double total_ativo = (dinheiro_corretora - taxa_compra_ativa);

				System.out.println("Invest. passivo $ " + total_passivo + " BTC " + (total_passivo / valor_btc_Compra));
				System.out.println("Invest. ativo   $ " + total_ativo + " BTC " + (total_ativo / valor_btc_Compra));
				
				melhor_negocio.put(corretora.getCodigo(), (total_passivo / valor_btc_Compra));
			} catch (NullPointerException e) {
				System.out.println("\n -------- Sem valores de compra -------------");
			}
			System.out.println();
		}
		
		Double valor_result = 0.0;
		String campea = "";
		for (Corretora_Enum corretora : lista) {
			Double atual = melhor_negocio.get(corretora.getCodigo());
			try {
				if (valor_result < atual) {
					campea = corretora.getCodigo();
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("\n\n\n");
		System.out.println("CAMPEA " + campea + "  " + melhor_negocio.get(campea));
		System.out.println("\n\n\n");
		maiorPrecoVendaBTC(campea, melhor_negocio.get(campea));
		
	}
	

	private static void maiorPrecoVendaBTC(String codCorretora, Double BTCvalor){
		
		List<Corretora_Enum> lista = (List<Corretora_Enum>) Arrays.asList(Corretora_Enum.values());
		HashMap<String, Double> melhor_negocio = new HashMap<>();
		
		for (Corretora_Enum corretora : lista) {

			Exchange exchange = exchange_Info.get(corretora.getCodigo());
			Order_Book_Stats order_book_stats = order_book_stats_Info.get(corretora.getCodigo());
			
			Double entrada_corretora_BTC = BTCvalor;
			
			if(!corretora.getCodigo().equalsIgnoreCase(codCorretora)){
				// TAXA ENTRADA NA CORRETORA
				entrada_corretora_BTC -= BTCvalor * exchange.getFees().getInBTC().get(0); 	// %
				entrada_corretora_BTC -= exchange.getFees().getInBTC().get(1); 				// reais
				// TRANSFERENCIA & MINERAÇÃO
				entrada_corretora_BTC -= precoTransacaoBTC;
			}								
			
			// TAXA TRANSAÇÃO VENDA CORRETORA
			Double taxa_venda_ativa = 0.0;
			Double taxa_venda_passiva = 0.0;
			taxa_venda_passiva += entrada_corretora_BTC * exchange.getFees().getTradeBook().get(0); // %
			taxa_venda_ativa += entrada_corretora_BTC * exchange.getFees().getTradeMarket().get(0); // %
			
			
			// TOTAL CORRETORA
			Double total_passivo = (entrada_corretora_BTC - taxa_venda_passiva);
			Double total_ativo = (entrada_corretora_BTC - taxa_venda_ativa);
			
			try {
				
				Double valor_btc_Venda = Double.parseDouble(order_book_stats.getAsk());
				System.out.println("Corretora " +corretora.getNome() );
				System.out.println("Invest. passivo $ " + total_passivo + "\t\t BTC " + (total_passivo * valor_btc_Venda));
				System.out.println("Invest. ativo   $ " + total_ativo + "\t\t BTC " + (total_ativo * valor_btc_Venda));
				System.out.println();
			
			} catch (NullPointerException e) {
				System.out.println("\n -------- Sem valor de venda -------------");
			}			
		}	
		
	}	
	

	private static JsonObject getTicker(String ticker) throws Exception {
		String object = chamadaJson(ticker);
		// System.out.println(object);
		Gson gson = new Gson();
		Type ticker_Type = new TypeToken<HashMap<String, Ticket>>() {
		}.getType();

		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(object);
		JsonObject ticketObject = jsonTree.getAsJsonObject();

		// Object obj1 = ticketObject.get("timestamp");
		// JsonElement obj2 = ticketObject.get("ticker_24h");
		// Totalizadores total_24h_currency = gson.fromJson(obj2.getAsJsonObject().get("total"), Totalizadores.class);
		// HashMap<String, Ticket> ticker_24h_currency = gson.fromJson(obj2.getAsJsonObject().get("exchanges"), ticker_Type);
		// JsonElement obj3 = ticketObject.get("ticker_12h");
		// Totalizadores total_12h_currency = gson.fromJson(obj3.getAsJsonObject().get("total"), Totalizadores.class);
		// HashMap<String, Ticket> ticker_12h_currency = gson.fromJson(obj3.getAsJsonObject().get("exchanges"), ticker_Type);
		// JsonElement obj4 = ticketObject.get("ticker_1h");
		// Totalizadores total_1h_currency = gson.fromJson(obj4.getAsJsonObject().get("total"), Totalizadores.class);
		// HashMap<String, Ticket> ticker_1h_currency = gson.fromJson(obj4.getAsJsonObject().get("exchanges"), ticker_Type);
		// Object obj5 = ticketObject.get("rates");
		return ticketObject;

	}

	private static HashMap<String, Exchange> getExchange(String exchange) throws Exception { // diário
		String object = chamadaJson("http://api.bitvalor.com/v1/exchanges.json");
		// System.out.println(object);
		Type exchange_Type = new TypeToken<HashMap<String, Exchange>>() {
		}.getType();
		HashMap<String, Exchange> exchangeCurrency = gson.fromJson(object, exchange_Type);
		// System.out.println(exchangeCurrency.get("MBT").toString());
		return exchangeCurrency;
	}

	private static HashMap<String, Order_Book_Stats> getOrder_book_stats(String order_book_stats) throws Exception { // minuto a minuto
		String object = chamadaJson(order_book_stats);
		// System.out.println(object);
		Type Order_Book_Stats_Type = new TypeToken<HashMap<String, Order_Book_Stats>>() {
		}.getType();
		HashMap<String, Order_Book_Stats> orderBookCurrency = gson.fromJson(object, Order_Book_Stats_Type);
		// System.out.println(orderBookCurrency.get("total").toString());
		return orderBookCurrency;
	}

	private static String chamadaJson(String caminho) throws Exception {
		if (caminho.contains(".com")) {
			return readUrl(caminho);
		} else {
			return readFile(caminho);
		}
	}

	private static String readFile(String file) throws Exception {
		String arquivo = System.getProperty("user.dir") + "/bitvalor/" + file;
		Reader reader = new FileReader(new File(arquivo));
		return IOUtils.getStringFromReader(reader);
	}

	private static String readUrl(String urlCaminho) throws Exception {

		URL url = new URL(urlCaminho);

		BufferedReader reader = null;
		try {
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();

			/**
			 * Fazer tratamento caso - urlConnection.getResponseCode(); 200 - OK: Requisição bem sucedida 304 - Não modificado: Dados não sofreram alterações desde a última requisição 429 - Muitas requisições: Número de requisições acima do Limite permitido. Continuar desrespeitando o limite irá ativar um banimento automático do seu IP
			 */

			reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}
