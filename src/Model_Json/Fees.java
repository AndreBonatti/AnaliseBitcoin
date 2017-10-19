package Model_Json;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.*;

public class Fees {

	/**
	 * taxas para depósito em Reais. O primeiro valor é percentual (%) e o segundo um valor fixo em R$ [ %, R$ ]
	 */
	@SerializedName("in_BRL")
	private List<Double> inBRL = null;
	/**
	 * taxas para depósito em BTC
	 */
	@SerializedName("in_BTC")
	private List<Double> inBTC = null;

	/**
	 * taxas para saques em Reais
	 */
	@SerializedName("out_BRL")
	private List<Double> outBRL = null;
	/**
	 * taxas para saques em BTC
	 */
	@SerializedName("out_BTC")
	private List<Double> outBTC = null;
	/**
	 * taxas para ordem de compra ou venda no livro de ofertas
	 */
	@SerializedName("trade_book")
	private List<Double> tradeBook = null;// ordem passiva

	/**
	 * taxas para ordem de compra ou venda a mercado (encontra alguma correspondente no livro de ofertas)
	 */
	@SerializedName("trade_market")
	private List<Double> tradeMarket = null; // ordem ativa

	public Fees() {
	}

	/**
	 * 
	 * @param tradeBook
	 * @param inBRL
	 * @param outBRL
	 * @param tradeMarket
	 * @param outBTC
	 * @param inBTC
	 */
	public Fees(List<Double> inBRL, List<Double> inBTC, List<Double> outBRL, List<Double> outBTC, List<Double> tradeBook, List<Double> tradeMarket) {
		super();
		this.inBRL = inBRL;
		this.inBTC = inBTC;
		this.outBRL = outBRL;
		this.outBTC = outBTC;
		this.tradeBook = tradeBook;
		this.tradeMarket = tradeMarket;
	}

	public List<Double> getInBRL() {
		return inBRL;
	}

	public void setInBRL(List<Double> inBRL) {
		this.inBRL = inBRL;
	}

	public List<Double> getInBTC() {
		return inBTC;
	}

	public void setInBTC(List<Double> inBTC) {
		this.inBTC = inBTC;
	}

	public List<Double> getOutBRL() {
		return outBRL;
	}

	public void setOutBRL(List<Double> outBRL) {
		this.outBRL = outBRL;
	}

	public List<Double> getOutBTC() {
		return outBTC;
	}

	public void setOutBTC(List<Double> outBTC) {
		this.outBTC = outBTC;
	}

	public List<Double> getTradeBook() {
		return tradeBook;
	}

	public void setTradeBook(List<Double> tradeBook) {
		this.tradeBook = tradeBook;
	}

	public List<Double> getTradeMarket() {
		return tradeMarket;
	}

	public void setTradeMarket(List<Double> tradeMarket) {
		this.tradeMarket = tradeMarket;
	}

	@Override
	public String toString() {
		return "Fees [inBRL=" + inBRL + ", inBTC=" + inBTC + ", outBRL=" + outBRL + ", outBTC=" + outBTC + ", tradeBook=" + tradeBook + ", tradeMarket=" + tradeMarket + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(tradeBook).append(inBRL).append(outBRL).append(tradeMarket).append(outBTC).append(inBTC).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Fees) == false) {
			return false;
		}
		Fees rhs = ((Fees) other);
		return new EqualsBuilder().append(tradeBook, rhs.tradeBook).append(inBRL, rhs.inBRL).append(outBRL, rhs.outBRL).append(tradeMarket, rhs.tradeMarket).append(outBTC, rhs.outBTC).append(inBTC, rhs.inBTC).isEquals();
	}

}
