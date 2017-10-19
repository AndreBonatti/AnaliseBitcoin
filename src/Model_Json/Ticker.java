package Model_Json;

import com.google.gson.annotations.SerializedName;

// https://api.bitvalor.com/v1/ticker.json

public class Ticker {

	@SerializedName("last")
	public Double last;
	@SerializedName("open")
	public Double open;
	@SerializedName("high")
	public Double high;
	@SerializedName("low")
	public Double low;
	@SerializedName("vol")
	public Double vol;
	@SerializedName("vwap")
	public Double vwap;
	@SerializedName("money")
	public Double money;
	@SerializedName("trades")
	public Integer trades;

	public Ticker() {
		// TODO Auto-generated constructor stub
	}

	public Double getLast() {
		return last;
	}

	public void setLast(Double last) {
		this.last = last;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getVol() {
		return vol;
	}

	public void setVol(Double vol) {
		this.vol = vol;
	}

	public Double getVwap() {
		return vwap;
	}

	public void setVwap(Double vwap) {
		this.vwap = vwap;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getTrades() {
		return trades;
	}

	public void setTrades(Integer trades) {
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "Ticker [last=" + last + ", open=" + open + ", high=" + high + ", low=" + low + ", vol=" + vol + ", vwap=" + vwap + ", money=" + money + ", trades=" + trades + "]";
	}

}
