package animals;
import java.util.Random;
import diet.*;
import food.EFoodType;

import mobility.*;
import utilities.*;

/**
 * 
 * @author tomer handali 206751489 and adi godosi 316413780
 *
 */
public class Lion extends Predator{
	
	private int scarCount;
	
	public static final int defScars=0;
	
	public static final double def_weight = 408.2;
	public static final Point def_location = new Point(20,0);
	
	public Lion(String s)
	{
		this(s,def_location);
		
	}
	
	public Lion(String s, Point p)
	{
		this(s,p,def_weight);

	}
	public Lion(String s, Point p,double w)
	{
		this(s,p,w,defScars);
		
	}
	public Lion(String s, Point p, double w, int scars)
	{
		super(s,p);
		
		MessageUtility.logConstractor("Lion", s);

		this.setWeight(w);
		this.setScars(scars);
		this.setDiet(new Carnivore());
	}
	
	
	public void roar()
	{
		MessageUtility.logSound(this.getName(), "Roars, then stretches and shakes its mane");
		addScar();
	}
	
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.NOTFOOD);
		
		return EFoodType.NOTFOOD;
		
	}
	
	public void addScar()
	{
		Random rand = new Random();
		int guess = rand.nextInt(2);
		if (guess==1)
			setScars(this.scarCount+1);
			
	}
	
	private boolean setScars(int s)
	{
		MessageUtility.logSetter(this.getName(), "setScars", s, true);
		
		return true;
	}
	
	public int getScars() {
		
		MessageUtility.logGetter(this.getName(), "getScars", this.scarCount);
		
		return this.scarCount;
		
	}
	
	public String toString()
	{
		return "[ Lion]: "+this.getName();
	}

}
