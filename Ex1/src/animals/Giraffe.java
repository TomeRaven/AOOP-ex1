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
public class Giraffe extends Vegeterian{
	
	private double neckLength=0;
	
	public final static double minNeckLength=1.0;
	public final static double maxNeckLength=2.5;
	public final static double defNeckLength=1.5;
	public static final double def_weight = 450;
	public static final Point def_location = new Point(50,0);
	
	public Giraffe(String s)
	{
		this(s,def_location);

	}
	
	public Giraffe(String s, Point p)
	{
		this(s,p,def_weight);

	}
	
	public Giraffe(String s, Point p, double w)
	{
		this(s,p,w,defNeckLength);
	}
	
	public Giraffe(String s, Point p, double w, double n)
	{
		super(s,p);
		
		MessageUtility.logConstractor("Giraffe", s);

		this.setWeight(w);
		
		this.setNeckLength(n);
		
		this.setDiet(new Herbivore());
		
	}
	
	public void chew()
	{
		MessageUtility.logSound(this.getName(), "Bleats and Stomps its legs, then chews");
	}
	
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.MEAT);
		
		return EFoodType.MEAT;
		
	}
	
	public boolean setNeckLength(double t)
	{
		boolean x=true;
		
		if(t<minNeckLength||t>maxNeckLength)
			x = false;
		else
			this.neckLength=t;
		
		MessageUtility.logSetter(this.getName(), "setNeckLength", t, x);
		
		if(this.neckLength==0&&x==false) // constructor call -> must be initialized with default value
		{
			this.neckLength=defNeckLength;
			x=true;
			MessageUtility.logSetter(this.getName(), "setNeckLength", defNeckLength, x);

		}
		
		return x;
		
	}
	
	public double getNeckLength() {
		
		MessageUtility.logGetter(this.getName(), "getNeckLength", def_location);
		
		return this.neckLength;
		
	}
	
	public String toString()
	{
		return  "[ Giraffe]: "+this.getName();
	}

}
