package stockmaker.beans;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Stock {

	int id;
	String companyName;
	String stockSymbol;
	BigDecimal newPrice;
	BigDecimal priceFrom;
	BigDecimal openingPrice;
	BigDecimal closingPrice;
	BigDecimal gainPercent;
	BigDecimal volume;
	
	public Stock(String name, String symbol, String price, String op, String cp, String volume) {
		this.companyName= name;
		this.stockSymbol = symbol;		
		this.openingPrice = new BigDecimal(op);
		this.closingPrice = new BigDecimal(cp);	
		this.volume = new BigDecimal(volume);
		this.updatePrice(new BigDecimal(price));
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	
	/**
	 * Update the price of the stock. When doing this also update the stock gain percentage.
	 * @param price
	 */
	public void updatePrice(BigDecimal price) {
		if(this.priceFrom == null) {
			this.priceFrom = price;
		} else {
			this.priceFrom = newPrice;
		}
		this.newPrice = price;
		
		BigDecimal diff = (newPrice.subtract(openingPrice));			
		BigDecimal inc = diff.divide(openingPrice, 3, RoundingMode.CEILING);
		this.gainPercent = inc.multiply(new BigDecimal("100"));
		
	}
	
	/**
	 * Put a stock
	 * @param amount	
	 */
	public void buy(int amount) {
		// Increase the price of the stock by the percentage.
		this.updatePrice(newPrice.add(calcChange(amount)));
		// emit a stock price change
	}
	
	/**
	 * sell stock
	 * @param amount
	 */
	public void sell(int amount) {
		// decrease the price of the stock by the percentage.
		this.updatePrice(newPrice.subtract(calcChange(amount)));
		// emit a stock price change
	}
	
	/**
	 * Calculate the new price of the stock based on the total percentage volume bought or sold.
	 * @param amount
	 * @return
	 */
	private BigDecimal calcChange(int amount) {	
		//caclulate the volume percentage change of purchase		
		BigDecimal pc = BigDecimal.valueOf((100d/volume.doubleValue())*amount);		
		
		//Now calculate the price change based on the volume of hte sale 
		BigDecimal changedifference = BigDecimal.valueOf( 100d/newPrice.doubleValue() *pc.doubleValue());		
		return changedifference.setScale(2, RoundingMode.CEILING);	
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", companyName=" + companyName + ", stockSymbol=" + stockSymbol + ", lastPrice="
				+ newPrice + ", priceFrom=" + priceFrom + ", openingPrice=" + openingPrice + ", closingPrice="
				+ closingPrice + ", gainPercent=" + gainPercent + ", volume=" + volume + "]";
	}
	
	
	
}
