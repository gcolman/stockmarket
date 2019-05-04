package stockmaker.utils;

import java.util.HashMap;
import java.util.Map;

import stockmaker.beans.Stock;

public class StockLoader {

	private static Map<String, Stock> stocks = new HashMap<String, Stock>();
	
	public static Map<String, Stock> loadStocks(String stockfile) {	
		//load the stocks from file.
		stocks.put("RHT", new Stock("RedHat", "RHT", "182.26","181.26","181.26", "10000000" ));
		stocks.put("APPL", new Stock("Apple", "APPL", "356.34","352.34","360.34", "100000000"));
		stocks.put("GGL", new Stock("Google", "GGL", "17.99","17.78","17.26", "100000000" ));
		stocks.put("GGS", new Stock("Greggs", "GGS", "23.56","23.26","23.26", "1000000" ));
		stocks.put("THY", new Stock("TheHydrant", "THY", "347.81","347.26","347.26", "60000000" ));
		stocks.put("IBM", new Stock("IBM", "IBM", "12.99","112.26","121.26", "100000000" ));
		stocks.put("BER", new Stock("Beer", "BER", "400.01","400.26","400.26", "20000000" ));
		stocks.put("SRU", new Stock("ShotgunsRUs", "SRU", "2389.22","400.26","400.26", "4000000" ));
		stocks.put("FFF", new Stock("FatFingerFun", "FFF", "390.62","390.26","399.26", "150000000" ));
		stocks.put("SAB", new Stock("SouthAfricanBeer", "SAB", "12.01","112.26","121.26", "30000000" ));
		
		return stocks;
	}
	
	public static String toS() {
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, Stock> entry : stocks.entrySet()) {
		    sb.append(entry.getKey() + " = " + entry.getValue().toString() +"\n");
		}
		return sb.toString();
	}
	
}
