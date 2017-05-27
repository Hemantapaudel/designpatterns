package observerdesign;

import java.util.ArrayList;
import java.util.List;

//Uses the Subject interface to update all Observers

interface Subject {
	
	public void register(Observer o);

	public void unregister(Observer o);

	public void notifyObserver();

}

// observer interface
interface Observer {
	public void update(double ibmPrice, double aaplPrice, double googPrice);
	
}

// implemented subject class
class StockGrabberSubject implements Subject {

	List<Observer> observers = new ArrayList<Observer>();
	
	private double ibmPrice;
	private double aaplPrice;
    private double googPrice;
	
	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
			observers.forEach(obserser -> obserser.update(ibmPrice, aaplPrice, googPrice));
	}
	
	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}
	
	public void setAaplPrice(double aaplPrice) {
		this.aaplPrice = aaplPrice;
		notifyObserver();
	}
	
	public void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
		notifyObserver();
	}

}




class StockObserver implements Observer {

	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;

	private static int observerIDTracker = 0;
	private int observerID;

	public StockObserver(Subject stockGrabber) {
		this.observerID = ++observerIDTracker;
		System.out.println("New Observer " + this.observerID);
		stockGrabber.register(this);
	}

	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;
		printThePrices();
	}

	public void printThePrices() {
		System.out.println(observerID + "\nIBM: " + ibmPrice + "\nAAPL: "
				+ aaplPrice + "\nGOOG: " + googPrice + "\n");
	}



}


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
