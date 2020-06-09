package ceational_design_patterns.prototype;

interface Prototype extends Cloneable {
	public abstract Object prototype ( )throws CloneNotSupportedException;
}

class ConcretePrototype implements Prototype {
	
	@Override
	public Object prototype() throws CloneNotSupportedException {
		return super.clone();
		
	}
}

public class ProtoTypeDesingPattern {

	public static void main( String arg[] ) throws CloneNotSupportedException 
	{
		ConcretePrototype obj1= new ConcretePrototype ();
		ConcretePrototype obj2 = (ConcretePrototype) obj1.prototype();
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
	}

}
