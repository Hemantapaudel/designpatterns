package observerdesign;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable {
	private String stock;
	private double price;
	private Subject stockGrabber;

	public GetTheStock(Subject stockGrabber, int newStartTime, String newStock,
			double newPrice) {
		this.stockGrabber = stockGrabber;
		stock = newStock;
		price = newPrice;
	}

	public void run() {
		double randNum = (Math.random() * (.06)) - .03;
		DecimalFormat df = new DecimalFormat("#.##");
		price = Double.valueOf(df.format((price + randNum)));
		if (stock == "IBM")
			((StockGrabber) stockGrabber).setIbmPrice(price);
		if (stock == "AAPL")
			((StockGrabber) stockGrabber).setAaplPrice(price);
		if (stock == "GOOG")
			((StockGrabber) stockGrabber).setGoogPrice(price);
	}

}
