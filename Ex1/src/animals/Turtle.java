package animals;

import food.EFoodType;
import diet.*;
import mobility.*;
import utilities.*;
/**
 * 
 * @author tomer handali 206751489 and adi godosi 316413780
 *
 */
public class Turtle extends Vegeterian{
	
	private int age=-1;
	
	public final static int defAge=1;
	public final static int minAge=0;
	public final static int maxAge=500;
	
	public static final double def_weight = 1;
	public static final Point def_location = new Point(80,0);
	
	public Turtle(String s)
	{
		this(s,def_location);

	}
	
	public Turtle(String s, Point p)
	{
		this(s,p,def_weight);

	}
	public Turtle(String s, Point p, double w)
	{
		this(s,p,w,defAge);
	}
	public Turtle(String s, Point p, double w, int a)
	{
		super(s,p);
		
		MessageUtility.logConstractor("Turtle", s);

		this.setWeight(w);
		this.setAge(a);
		this.setDiet(new Herbivore());
	}
	
	public void chew()
	{
		MessageUtility.logSound(this.getName(), "Retracts its head in then eats quietly");
	}
	
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.MEAT);
		
		return EFoodType.MEAT;
		
	}
	
	public boolean setAge(int a)
	{
		boolean x=true;
		
		if(a<minAge||a>maxAge)
			x= false;
		else
			this.age=a;
		
		MessageUtility.logSetter(this.getName(), "setAge", a, x);
		
		if(this.age==-1) // constructor call -> if a isnt valid, age must be initialized with default value
		{
			x=true;
			this.age=defAge;
			
			MessageUtility.logSetter(this.getName(), "setAge", defAge, x);

		}
		return x;
		
	}
	
	public int getAge() {
		
		MessageUtility.logGetter(this.getName(), "getAge", this.age);
		
		return this.age;
		
	}
	
	public String toString()
	{
		return  "[ Turtle]: "+this.getName();
	}

}
