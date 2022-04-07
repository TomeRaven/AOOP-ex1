package animals;

import mobility.Point;
/**
 * This class is meant to be a parent to animals with roar methods so makesound can be properly implemented
 * @author tomer handali 206751489 and adi godosi 316413780
 *
 */
public abstract class Predator extends Animal {

	public Predator(String s, Point p) {
		super(s, p);
		
	}
	
	public void makeSound()
	{
		roar();
		
	}
	
	public abstract void roar();

}
