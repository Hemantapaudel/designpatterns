package structural_patterns.visitor_pattern;

import java.util.ArrayList;
import java.util.List;

// all item will implement this interface
interface Visitable {
	
	void accept(Visitor visitor);

}

class Book implements Visitable{
	  private double price;
	  private double weight;
	  
	  
	  public Book(double price, double weight) {
		super();
		this.price = price;
		this.weight = weight;
	}

	//accept the visitor
	  public void accept(Visitor visitor) {
	    visitor.visit(this);
	  }
	  
	  public double getPrice() {
	    return price;
	  }
	  public double getWeight() {
	    return weight;
	  }
	}

class DVD implements Visitable {

	private double price;
	private double weight;

	  public DVD(double price, double weight) {
		super();
		this.price = price;
		this.weight = weight;
	}
	// accept the visitor
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public double getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}
}

class CD implements Visitable {

	private double price;
	private double weight;


	  public CD(double price, double weight) {
		super();
		this.price = price;
		this.weight = weight;
	}
	
	// accept the visitor
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public double getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}
}


interface Visitor {
	 void visit(Book book);

	 void visit(CD cd);

	 void visit(DVD dvd);
}

class PostageVisitor implements Visitor{
	
	private double totalPostageForCart;

	@Override
	public void visit(Book book) {
		totalPostageForCart = totalPostageForCart +	book.getPrice();
	}

	@Override
	public void visit(CD cd) {
		totalPostageForCart += cd.getPrice();
	}

	@Override
	public void visit(DVD dvd) {
		totalPostageForCart += dvd.getPrice();
	}
	
	public double getTotalPostageForCart() {
		return this.totalPostageForCart;
	}
	
}


public class ShopingCartVisitorExample{
	public static void main(String[] args) {
		
		 //normal shopping cart stuff
		  List<Visitable> items = new ArrayList<Visitable>();
		  items.add(new Book(130,120));
		  items.add(new Book(120,120));
		  items.add(new DVD(150,120));
		  items.add(new CD(160,120));
		  
		
		  System.out.println(calculatePostage(items));
		
	}
	
	
	public static  double calculatePostage(List<Visitable> items) {
	    //create a visitor
	    PostageVisitor visitor = new PostageVisitor();
	    //iterate through all items
	    for(Visitable item: items) {
	      item.accept(visitor);
	    }
	    double postage = visitor.getTotalPostageForCart();
	    return postage;
	  }
	
}


