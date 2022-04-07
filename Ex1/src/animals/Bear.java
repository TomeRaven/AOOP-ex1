package animals;

import food.*;
import diet.*;
import mobility.*;
import utilities.*;

/**
 * 
 * @author tomer handali 206751489 and adi godosi 316413780
 *
 */
public class Bear extends Predator {
	private String furColor=null;
	
	public final static String[] furs = {"GRAY","BLACK","WHITE"};
	public final static String defFur=new String("GRAY");
	public static final double def_weight = 308.2;
	public static final Point def_location = new Point(100,5);
	
	public Bear(String s)
	{
		this(s,def_location);
		
	}
	
	
	public Bear(String s, Point p)
	{
		this(s,p,def_weight);
		
	}
	public Bear(String s, Point p, double w)
	{
		this(s,p,w,defFur);
	}
	
	public Bear(String s, Point p, double w, String f)
	{
		super(s,p);
		
		MessageUtility.logConstractor("Bear", s);
		
		this.setFurColor(f);
		this.setWeight(w);
		this.setDiet(new Omnivore());
		
	}
	
	
	public void roar()
	{
		MessageUtility.logSound(this.getName(), "Stands on its hind legs, roars and scratches its belly");
	}
	
	public EFoodType getFoodtype()
	{
		MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.MEAT);
		
		return EFoodType.MEAT;
		
	}
	
	public boolean setFurColor(String f)
	{
		boolean x=false;
		
		for(int i=0;i<furs.length;++i)
			if(furs[i]==f) 
			{
				this.furColor=f;
				x = true;
				break;
			}
			
		MessageUtility.logSetter(this.getName(), "setFurColor", f, x);
		
		if(this.furColor==null&&x==false) // constructor call -> must be initialized with default value
		{
			this.furColor=defFur;
			x=true;
			MessageUtility.logSetter(this.getName(), "setFurColor", defFur, x);
		}

		return x;
		
	}
	
	public String getFurColor() {
		
		MessageUtility.logGetter(this.getName(), "getFurColor", this.furColor);
		
		return this.furColor;
		
	}
	
	public String toString()
	{
		return  "[ Bear]: "+this.getName();
	}

}
