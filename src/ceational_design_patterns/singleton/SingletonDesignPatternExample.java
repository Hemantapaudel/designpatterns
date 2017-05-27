package ceational_design_patterns.singleton;

/**
 * Static block initialization implementation is similar to eager
 * initialization, except that instance of class is created in the static block
 * that provides option for exception handling.
 */
class StaticBlockSingleton {
	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {
	}
	// static block initialization for exception handling
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException(
					"Exception occured in creating singleton instance");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}
}

// Lazy Initialization
class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {
	}
	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}

// Thread Safe Singleton
class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
	}

	public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}

// Bill Pugh Singleton Implementation
/**
 * Notice the private inner static class that contains the instance of the
 * singleton class. When the singleton class is loaded, SingletonHelper class is
 * not loaded into memory and only when someone calls the getInstance method,
 * this class gets loaded and creates the Singleton class instance
 *
 */
class BillPughSingleton {
	private BillPughSingleton() {
	}

	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}


/**
 * 
 * singleton using enum
 */
enum EnumSingleton {

    INSTANCE;
    
    public  void doSomething(){
        System.out.println("singleton method call");
    }
}
public class SingletonDesignPatternExample {
	public static void main(String[] args) {

		EnumSingleton.INSTANCE.doSomething();
		
	}

}
