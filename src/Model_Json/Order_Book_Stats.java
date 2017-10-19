package Model_Json;

// https://api.bitvalor.com/v1/order_book_stats.json

/**
 * 
 * {"total":{"bid":17117.73,"ask":9900,"bid_vol":79586.107688756,"bid_money":780385427.50762,"bid_count":2395,"ask_vol":1563.0909540923,"ask_money":53146715.942763,"ask_count":2738}
 * ,"LOC":{"bid":17117.73,"ask":9900,"bid_vol":54397.794902486,"bid_money":752038253,"bid_count":54,"ask_vol":38.649181632324,"ask_money":604572.26,"ask_count":54}
 * ,"NEG":{"bid":14380.05,"ask":14550.64,"bid_vol":12.38943798,"bid_money":159024.4708218,"bid_count":105,"ask_vol":18.71873819,"ask_money":321671.62012415,"ask_count":66}
 * ,"MBT":{"bid":14340,"ask":14340,"bid_vol":18191.0174039,"bid_money":18949236.739698,"bid_count":629,"ask_vol":503.89638276,"ask_money":17704774.00903,"ask_count":846}
 * ,"ARN":{"bid":14310,"ask":14600,"bid_vol":5.8157,"bid_money":10174.633761,"bid_count":16,"ask_vol":1.9636,"ask_money":34938.1493,"ask_count":12}
 * ,"FOX":{"bid":14202.01,"ask":14270,"bid_vol":4920.07194246,"bid_money":6645209.0491687,"bid_count":1310,"ask_vol":874.35314773,"ask_money":32428263.342085,"ask_count":1523}
 * ,"B2U":{"bid":13830,"ask":13899,"bid_vol":2059.01830193,"bid_money":2583529.614173,"bid_count":281,"ask_vol":125.50990378002,"ask_money":2052496.5622232,"ask_count":237} }
 * 
 */

public class Order_Book_Stats {

	/**
	 * melhor (mais alta) oferta de compra
	 */
	private String bid;
	/**
	 * melhor (mais baixa) oferta de venda
	 */
	private String ask;
	/**
	 * total em BTC de ofertas de compra
	 */
	private String bid_vol;
	/**
	 * total em Reais de ofertas de compra
	 */
	private String bid_money;
	/**
	 * número de ofertas de compra
	 */
	private String bid_count;
	/**
	 * total em BTC de ofertas de venda
	 */
	private String ask_vol;
	/**
	 * total em Reais de ofertas de venda
	 */
	private String ask_money;
	/**
	 * número de ofertas de venda
	 */
	private String ask_count;

	public Order_Book_Stats() {
		// TODO Auto-generated constructor stub
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getBid_vol() {
		return bid_vol;
	}

	public void setBid_vol(String bid_vol) {
		this.bid_vol = bid_vol;
	}

	public String getBid_money() {
		return bid_money;
	}

	public void setBid_money(String bid_money) {
		this.bid_money = bid_money;
	}

	public String getBid_count() {
		return bid_count;
	}

	public void setBid_count(String bid_count) {
		this.bid_count = bid_count;
	}

	public String getAsk_vol() {
		return ask_vol;
	}

	public void setAsk_vol(String ask_vol) {
		this.ask_vol = ask_vol;
	}

	public String getAsk_money() {
		return ask_money;
	}

	public void setAsk_money(String ask_money) {
		this.ask_money = ask_money;
	}

	public String getAsk_count() {
		return ask_count;
	}

	public void setAsk_count(String ask_count) {
		this.ask_count = ask_count;
	}

	@Override
	public String toString() {
		return "Order_Book_Stats [bid=" + bid + ", ask=" + ask + ", bid_vol=" + bid_vol + ", bid_money=" + bid_money + ", bid_count=" + bid_count + ", ask_vol=" + ask_vol + ", ask_money=" + ask_money + ", ask_count=" + ask_count + "]";
	}

}
