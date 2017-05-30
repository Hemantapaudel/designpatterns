package structural_patterns.decorator_pattern;

interface Pizza{
	public String makePizza();
}

class PlainPizza implements Pizza{

	@Override
	public String makePizza() {
		return "plain pizza";
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
		// TODO Auto-generated method stub
		return pizza.makePizza();
	}
}

// Adding new functionality on pizza


class VegCheesPiza extends PizzaDecorator{

	public VegCheesPiza(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public String makePizza() {
		return pizza.makePizza()+ ", Veggie  and Cheese";
	}
	
}

class ChickenCheesPiza extends PizzaDecorator{

	public ChickenCheesPiza(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public String makePizza() {
		return pizza.makePizza()+ ", Chicken and Cheese";
	}
}



public class DecoratorDesignPatternDemo {

	public static void main(String[] args) {

		Pizza pizza = new ChickenCheesPiza( new VegCheesPiza(new PlainPizza()));
		System.out.println(pizza.makePizza());
		
	}

}
