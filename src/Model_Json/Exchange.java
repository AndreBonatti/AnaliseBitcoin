package Model_Json;

// https://api.bitvalor.com/v1/exchanges.json


/**
 * 
 * 
 * {
	  "MBT":
		{"name":"Mercado Bitcoin",
		"color":"fb8072",
		"url":"https://www.mercadobitcoin.com.br",
		"url_book":"https://www.mercadobitcoin.com.br/BRLBTC/negociacoes/",
		"fees":{
			"in_BRL":[0.0199,2.9],
			"in_BTC":[0,0],
			"out_BRL":[0.0199,2.9],
			"out_BTC":[0,0],
			"trade_book":[0.003,0],
			"trade_market":[0.007,0]
			}
		}
	}
 * 
 */
public class Exchange {

	private String name;
	private String url;
	private Fees fees;
	

	public Exchange() {
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Fees getFees() {
		return fees;
	}
	
	public void setFees(Fees fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Exchange [name=" + name + ", url=" + url + ", fees=" + fees.toString() + "]";
	}
	
	


}
