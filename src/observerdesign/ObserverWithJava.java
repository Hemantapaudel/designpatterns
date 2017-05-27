package observerdesign;

import java.util.Observable;
import java.util.Observer;


// this is a subject class
class DataStore extends Observable{
	 private String data;
	 
	  public String getData() {
	    return data;
	  }
	  
	  // register the observer to the subject
	  public void registerObserver(Observer obverser){
		  this.addObserver(obverser);
	  }
	  // De-register the observer
	  public void removeObservers(Observer obverser){
		  this.deleteObserver(obverser);
	  }
	  
	  // send notification
	  public void sentNotification(String message){
		  this.notifyObservers(message);
	  }
	  
	  
	  public void setData(String data) {
	    this.data = data;
	    //mark the observable as changed
	    setChanged();
	    sentNotification("message from data source");
	  }

}

class Screen implements Observer{
	
	public Screen(Observable observable){
		observable.addObserver(this);
	}
	
	@Override
	public void update(Observable observable, Object object) {		
		if(observable instanceof DataStore){
			System.out.println(" data ==::"+ ((DataStore)observable).getData());
		}
		if( object instanceof String){
			System.out.println(" On Observer, message ::: "+object);
		}
	}
}

public class ObserverWithJava {
	public static void main(String[] args) {
		DataStore subject = new DataStore();
		new Screen(subject);
		subject.setData("set new data on subject");
	}

}
