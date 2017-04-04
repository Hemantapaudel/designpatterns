package observerdesign.observerwithjavautils;

import java.util.Observable;
import java.util.Observer;

public class Screen implements Observer{
	public Screen(Observable observable){
		observable.addObserver(this);
	}
	@Override
	public void update(Observable observable, Object object) {		
		if(observable instanceof DataStore){
			System.out.println(" data ==::"+ ((DataStore)observable).getData());
		}
		if( object instanceof String){
			System.out.println("message ::: "+object);
		}
	}

}
