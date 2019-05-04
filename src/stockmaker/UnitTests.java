package stockmaker;

import java.util.Map;

import stockmaker.beans.Stock;
import stockmaker.utils.StockLoader;

public class UnitTests {

	public static void main(String[] args) {
		UnitTests t = new UnitTests();
		t.stocktests();
		
	}


	
	/**
	 * Test the stock
	 */
	public void stocktests() {
		// Test the loading of the stock
		Map<String, Stock> stockMap = StockLoader.loadStocks("");
		//System.out.println(StockLoader.toS());
		
		//Test the price update
		Stock stock = stockMap.get("GGS");
		System.out.println(stock.toString());
		stock.buy(9000);
		System.out.println(stock.toString());
		stock.buy(100);
		System.out.println(stock.toString());
		stock.sell(1000);
		System.out.println(stock.toString());
		stock.buy(567);
		System.out.println(stock.toString());
		stock.sell(2300);
		System.out.println(stock.toString());
		stock.buy(88);
		System.out.println(stock.toString());
		stock.sell(3409);
		System.out.println(stock.toString());
	}
	
	
}
