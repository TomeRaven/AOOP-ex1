package animals;
import utilities.MessageUtility;
import diet.*;
import food.*;
import mobility.*;
/**
 * 
 * @author tomer handali 206751489 and adi godosi 316413780
 *
 */
public abstract class Animal extends Mobile implements IEdible{
	
	private String name;
	private double weight=0;
	private IDiet diet;
	
	public Animal(String s, Point p)
	{
		super(p);
		MessageUtility.logConstractor("Animal",  s);
		setName(s);
		
	}
	
	
	private boolean setName(String s) {
		this.name=s;
		MessageUtility.logSetter(s, "setName", s, true);
		return true;
	}
	
	
	public double getWeight() {
		
		MessageUtility.logGetter(this.name, "getWeight", this.weight);
		
		return this.weight;
		
	}
	
	public String getName() {
		
		//MessageUtility.logGetter(this.name, "getName", this.name);
		
		return this.name;
		
	}
	
	public boolean setWeight(double w) 
	{
		boolean x=true;
		
		if(w<0)
			x=false;
		else
			this.weight=w;
		
		MessageUtility.logSetter(this.name, "setWeight", w, x);
		
		
		return x;
	}
	
	protected boolean setDiet(IDiet d)
	{
		this.diet=d;
		
		MessageUtility.logSetter(this.name, "setDiet", d, true);
		return true;
		
	}
	
	public abstract EFoodType getFoodtype();
	
	public abstract void makeSound();
	
	public boolean eat(IEdible other)
	{
		boolean x=true;
		double wadd=diet.eat(this, other);
		
		if(wadd==0)
			x = false;
		else
		{
			this.setWeight(this.weight+wadd);
			makeSound();
		}
		
		MessageUtility.logBooleanFunction(this.getName(), "eat", other, x);
		
		return x;
	}
	
	public double move(Point p)
	{
		double d=super.move(p);
		
		double w=this.getWeight();
		
		this.setWeight(w-(d*w*0.00025));
		
		boolean x= (d==0?false:true);
		
		MessageUtility.logSetter(this.name, "move", p, x);
		
		return d;
	}
}
