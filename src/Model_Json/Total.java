package Model_Json;

import com.google.gson.annotations.SerializedName;

public class Total {

	@SerializedName("last")
	public Float last;
	@SerializedName("high")
	public Float high;
	@SerializedName("low")
	public Float low;
	@SerializedName("vol")
	public Float vol;
	@SerializedName("vwap")
	public Float vwap;
	@SerializedName("money")
	public Float money;
	@SerializedName("trades")
	public Integer trades;

	public Total() {
	}

	public Float getLast() {
		return last;
	}

	public void setLast(Float last) {
		this.last = last;
	}

	public Float getHigh() {
		return high;
	}

	public void setHigh(Float high) {
		this.high = high;
	}

	public Float getLow() {
		return low;
	}

	public void setLow(Float low) {
		this.low = low;
	}

	public Float getVol() {
		return vol;
	}

	public void setVol(Float vol) {
		this.vol = vol;
	}

	public Float getVwap() {
		return vwap;
	}

	public void setVwap(Float vwap) {
		this.vwap = vwap;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Integer getTrades() {
		return trades;
	}

	public void setTrades(Integer trades) {
		this.trades = trades;
	}

}
