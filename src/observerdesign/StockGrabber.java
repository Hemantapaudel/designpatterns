package observerdesign;

import java.util.ArrayList;
import java.util.List;

//Uses the Subject interface to update all Observers

public class StockGrabber implements Subject {

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
