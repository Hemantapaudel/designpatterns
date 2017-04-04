package observerdesign.observerwithjavautils;

public class Main {
	public static void main(String[] args) {
		DataStore subject = new DataStore();
		new Screen(subject);
				
		subject.setData("set new data on subject");
		
	}

}
