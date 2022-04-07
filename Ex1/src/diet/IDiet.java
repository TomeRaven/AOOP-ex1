package diet;

import food.*;
import animals.*;
/**
 * 
 * @author tomer handali 206751489 and adi godosi 316413780
 *
 */
public interface IDiet {
	public boolean canEat(EFoodType food);
	public double eat(Animal animal, IEdible food);
}
