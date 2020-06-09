package structural_patterns.decorator_pattern;

interface Pizza{
	 String makePizza();
}

class PlainPizza implements Pizza{

	@Override
	public String makePizza() {
		return "plain pizza : ";
	}
	
}


// decorator class

abstract class PizzaDecorator implements Pizza{
	
	protected Pizza pizza;
	
	public PizzaDecorator(Pizza pizza){
		this.pizza = pizza;
	}
	
	@Override
	public String makePizza() {
		return pizza.makePizza();
	}
}

// Adding new functionality on pizza
class VegPizza extends PizzaDecorator{

	public VegPizza(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public String makePizza() {
		return pizza.makePizza()+ "+ Veggie ";
	}
	
}

// Adding new functionality on pizza
class CheesePizza extends PizzaDecorator{

	public CheesePizza(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String makePizza() {
		return pizza.makePizza()+ "+ Cheese ";
	}

}

// Adding new functionality on pizza
class ChickenPizza extends PizzaDecorator{

	public ChickenPizza(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public String makePizza() {
		return pizza.makePizza()+ "+ Chicken ";
	}
}



public class DecoratorDesignPatternDemo {

	public static void main(String[] args) {

		PlainPizza plainPizza = new PlainPizza();
		VegPizza vegPlanPizza = new VegPizza(plainPizza);
		CheesePizza cheesevegPizza = new CheesePizza(vegPlanPizza);
		ChickenPizza chickenCheesevegPizza = new ChickenPizza(cheesevegPizza);
		System.out.println(chickenCheesevegPizza.makePizza());

	}

}
