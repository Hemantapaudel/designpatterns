package observerdesign.stockexample;


public class GrabStocksExample {
	public static void main(String[] args) {
		StockGrabberSubject stockGrabber = new StockGrabberSubject();
		StockObserver observer1 = new StockObserver(stockGrabber);
		stockGrabber.setIbmPrice(197.00);
		stockGrabber.setAaplPrice(677.60);
		stockGrabber.setGoogPrice(676.40);
		System.out.println(observer1);

		StockObserver observer2 = new StockObserver(stockGrabber);
		stockGrabber.setIbmPrice(197.00);
		stockGrabber.setAaplPrice(677.60);
		stockGrabber.setGoogPrice(676.40);

		System.out.println("Delete one of the observer2");
		stockGrabber.unregister(observer2);
		stockGrabber.setIbmPrice(197.00);
		stockGrabber.setAaplPrice(677.60);
		stockGrabber.setGoogPrice(676.40);


	}

}
