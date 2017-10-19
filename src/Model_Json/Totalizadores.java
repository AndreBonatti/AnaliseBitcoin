package Model_Json;

import com.google.gson.annotations.SerializedName;

public class Totalizadores {
	/**
	 *{
	 *"last":14176.178647733,
	 *"high":26694.25,
	 *"low":12613.16,
	 *"vol":793.0379028422,
	 *"vwap":14251.022714874,
	 *"money":11301601.16716,
	 *"trades":7518}
	 */

	@SerializedName("last")
	public Double last;
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

	public Totalizadores() {
	}

	public Double getLast() {
		return last;
	}

	public void setLast(Double last) {
		this.last = last;
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
		return "Totalizadores [last=" + last + ", high=" + high + ", low=" + low + ", vol=" + vol + ", vwap=" + vwap + ", money=" + money + ", trades=" + trades + "]";
	}

}
