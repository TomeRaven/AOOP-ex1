package animals;

import mobility.Point;

/**
 *   This class is meant to be a parent to animals with chew methods so makesound can be properly implemented

 * @author tomer handali 206751489 and adi godosi 316413780
 *
 */
public abstract class Vegeterian extends Animal{
	
	public Vegeterian(String s, Point p)
	{
		super(s,p);
	}

	public void makeSound()
	{
		chew();
		
	}
	
	public abstract void chew();
}
