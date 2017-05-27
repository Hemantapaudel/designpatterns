package behavioral_patterns.change_of_responsibility;

/**
 * The Chain of Responsibility design pattern allows an object to send a command
 * without knowing what object will receive and handle it. The request is sent
 * from one object to another making them parts of a chain and each object in
 * this chain can handle the command, pass it on or do both. The most usual
 * example of a machine using the Chain of Responsibility is the vending machine
 * coin slot: rather than having a slot for each type of coin, the machine has
 * only one slot for all of them. The dropped coin is routed to the appropriate
 * storage place that is determined by the receiver of the command.
 * 
 * Intent: It avoids attaching the sender of a request to its receiver, giving
 * this way other objects the possibility of handling the request too.
 * 
 * The objects become parts of a chain and the request is sent from one object
 * to another across the chain until one of the objects will handle it.
 * 
 * @author Hemanta
 *
 */

class Request {
	private int m_value;
	private String m_description;

	public Request(String description, int value) {
		m_description = description;
		m_value = value;
	}

	public int getValue() {
		return m_value;
	}

	public String getDescription() {
		return m_description;
	}
}
/**
 * Handler interface  
 *
 */
abstract class Handler {
	protected Handler m_successor;

	public void setSuccessor(Handler successor) {
		m_successor = successor;
	}

	public abstract void handleRequest(Request request);
	
	protected void propagateRequest(Request request){
		if(m_successor != null)
		m_successor.handleRequest(request);
		else
			throw new RuntimeException("There is no handle available for this request");
	}
	
}

class ConcreteHandlerOne extends Handler {

	public void handleRequest(Request request) {
		if (request.getValue() < 0) { // if request is eligible handle it
			System.out.println("Negative values are handled by ConcreteHandlerOne:");
			System.out.println("\tConcreteHandlerOne.HandleRequest : "
			+ request.getDescription() + request.getValue());
		} else {
			System.out.println("passing the request to second handler");
			propagateRequest(request);
		}
	}
}

class ConcreteHandlerTwo extends Handler {
	public void handleRequest(Request request) {
		if (request.getValue() > 0) { // if request is eligible handle it
			System.out
					.println("Positive values are handled by ConcreteHandlerTwo:");
			System.out.println("\tConcreteHandlerTwo.HandleRequest : "
					+ request.getDescription() + request.getValue());
		} else {
			System.out.println("passing the request to third handler");
			propagateRequest(request);
		}
	}
}

class ConcreteHandlerThree extends Handler {
	public void handleRequest(Request request) {
		if (request.getValue() == 0) { // if request is eligible handle it
			System.out
					.println("Zero values are handled by ConcreteHandlerThree:");
			System.out.println("\tConcreteHandlerThree.HandleRequest : "
					+ request.getDescription() + request.getValue());
		} else {
			propagateRequest(request);
		}
	}
}

public class ChainOfResponsibilityExample {
	public static void main(String[] args) {
		// Setup Chain of Responsibility
		Handler h1 = new ConcreteHandlerOne();
		Handler h2 = new ConcreteHandlerTwo();
		Handler h3 = new ConcreteHandlerThree();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);

		// Send requests to the chain
		h1.handleRequest(new Request("Negative Value ", -1));
		h1.handleRequest(new Request("Negative Value ", 0));
		h1.handleRequest(new Request("Negative Value ", 1));
		h1.handleRequest(new Request("Negative Value ", 2));
		h1.handleRequest(new Request("Negative Value ", -5));
	}
}
