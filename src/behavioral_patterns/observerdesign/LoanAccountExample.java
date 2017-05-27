package behavioral_patterns.observerdesign;

import java.util.ArrayList;

interface Observer1 {
	public void update(float interest);
}

interface Subject1 {
	public void registerObserver(Observer1 observer);

	public void removeObserver(Observer1 observer);

	public void notifyObservers();
}

class Loan implements Subject1 {
	private ArrayList<Observer1> observers = new ArrayList<Observer1>();
	private String type;
	private float interest;
	private String bank;

	public Loan(String type, float interest, String bank) {
		this.type = type;
		this.interest = interest;
		this.bank = bank;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
		notifyObservers();
	}

	public String getBank() {
		return this.bank;
	}

	public String getType() {
		return this.type;
	}

	@Override
	public void registerObserver(Observer1 observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer1 observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		observers.forEach((observer) -> {
			observer.update(this.interest);
		});
	}
}

class Newspaper implements Observer1 {
	@Override
	public void update(float interest) {
		System.out.println("Newspaper: Interest Rate updated, new Rate is: "
				+ interest);
	}
}

class Internet implements Observer1 {
	@Override
	public void update(float interest) {
		System.out.println("Internet: Interest Rate updated, new Rate is: "
				+ interest);
	}
}

public class LoanAccountExample {
	public static void main(String[] args) {

		// this will maintain all loans information
		Newspaper printMedia = new Newspaper();
		Internet onlineMedia = new Internet();
		//subject or publisher  
		Loan personalLoan = new Loan("Personal Loan", 12.5f,"Standard Charterd");
		personalLoan.registerObserver(printMedia);
		personalLoan.registerObserver(onlineMedia);
		
		personalLoan.setInterest(3.5f);

	}

}
