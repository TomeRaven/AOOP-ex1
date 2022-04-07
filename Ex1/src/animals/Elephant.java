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
public class Elephant extends Vegeterian{
	private double trunkLength=0;
	
	public final static double minTrunkLength=0.5;
	public final static double maxTrunkLength=3;
	public final static double defTrunkLength=1.0;
	
	public static final double def_weight = 500;
	public static final Point def_location = new Point(50,90);

	
	public Elephant(String s)
	{
		this(s,def_location);
		

	}
	
	public Elephant(String s, Point p)
	{
		this(s,p,def_weight);		

	}
	public Elephant(String s, Point p, double w)
	{
		this(s,p,w,defTrunkLength);
	}
	
	public Elephant(String s, Point p, double w, double t)
	{
		super(s,p);
		
		MessageUtility.logConstractor("Elephant", s);
		
		this.setWeight(w);
		this.setTrunkLength(t);
		this.setDiet(new Herbivore());
		
	}
	
	public void chew()
	{
		MessageUtility.logSound(this.getName(), "Trumpets with joy while flapping its ears, then chews");
	}
	
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.MEAT);
		
		return EFoodType.MEAT;
		
	}
	
	public boolean setTrunkLength(double t)
	{
		boolean x=true;
		
		if(t<minTrunkLength||t>maxTrunkLength)
			x = false;
		else
		 this.trunkLength=t;
		
		MessageUtility.logSetter(this.getName(), "setTrunkLength", t, x);
		
		if(this.trunkLength==0&&x==false) // constructor call -> must be initialized with default value
		{
			this.trunkLength=defTrunkLength;
			x=true;
			MessageUtility.logSetter(this.getName(), "setTrunkLength", defTrunkLength, x);
		}
		
		return x;
		
	}
	
	public double getTrunkLength() {
		
		MessageUtility.logGetter(this.getName(), "getTrunkLength", this.trunkLength);
		
		return this.trunkLength;
		
	}
	
	public String toString()
	{
		return  "[ Elephant]: "+this.getName();
	}
}
