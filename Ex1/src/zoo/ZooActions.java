package zoo;


import animals.*;
import diet.*;
import food.*;
import plants.*;
import mobility.*;
import java.util.Scanner;
import java.util.Random;
/**
 * 
 * @author tomer handali 206751489 and adi godosi 316413780
 *
 */
public class ZooActions {
	
	
	private static final int minAnimals=3; // a member to present minimum number of animals in array
	private static Scanner sc = new Scanner(System.in); // input from user member
	
	/**
	 * 
	 * @param animal - the object(animal) that eats
	 * @param food - the object that is eaten
	 * @return - true if the animal has eaten the food, false if didnt
	 */
	public static boolean eat(Object animal, IEdible food)
	{
		Animal an;
		
		
		if(!(animal instanceof Animal))
			return false;
		
		an = (Animal) animal;
		return an.eat(food);
			
	}
	/**
	 * 
	 * @param animal - the object(animal) that moves
	 * @param point - the location the animal is requested to move to
	 * @return - returns true if the animal moved, false if didnt
	 */
	public static boolean move(Object animal, Point point)
	{
		Animal an;
		
		
		if(!(animal instanceof Animal))
			return false;
		
		if(!(Point.checkBoundaries(point)))
			return false;
		
		an = (Animal)animal;
		
		an.move(point);
		
		return true;
		
	}
	
	public static void main(String[] args)
	{
		Random rand=new Random();
		
		int arrSize=0;
		Animal[] arr;
		
		System.out.println("Enter number of animals in the zoo - must be at least 3");
		arrSize=sc.nextInt();
		if(arrSize<minAnimals)
			System.out.println("Invalid input - Array size defaulted at 3");
			
		arr = CreateAnimalArray(arrSize);
		
		arrMove(arr);
		 
		int numGuesses=arrSize/2;
	
		int a1;
		int a2;
		
		for(int i = 0;i<numGuesses;++i)
		{
			a1=rand.nextInt(arrSize);
			a2=rand.nextInt(arrSize);
			
			eat(arr[a1],arr[a2]);
			
		}
		
		
	}
	/**
	 * a method for creating an entire array of animals
	 * @param Size - size of animal array
	 * @return - An initialized animal array with the user's input
	 */
	private static Animal[] CreateAnimalArray(int Size)
	{
		Animal[] arr=new Animal[Size];
		int choice;
		
		
		for(int i=0;i<Size;++i)
		{
			System.out.println("\nTo create animal "+(i+1));
			System.out.println("Please select a number from the list to create a specific animal type:");
			System.out.println("1. Lion");
			System.out.println("2. Bear");
			System.out.println("3. Elephant");
			System.out.println("4. Giraffe");
			System.out.println("5. Turtle");
			
			choice=sc.nextInt();
			
			
			switch(choice)
			{
			case 1:
				arr[i]=createLion();
				break;
			
			case 2:
				arr[i]=createBear();
				break;
				
			case 3:
				arr[i]=createElephant();
				break;
				
			case 4:
				arr[i]=createGiraffe();
				break;
			
			case 5:
				arr[i]=createTurtle();
				break;
				
			default:
				System.out.println("\nInvalid input! select only within 1-5");
				
				--i;
				break;
			}
			
		}
		
		return arr;
	}
	/**
	 * a method for moving an array of animals
	 * 
	 * @param arr - array of animals
	 */
	private static void arrMove(Animal[] arr)
	{
		int x;
		int y;
		Point p;
		
		for(int i=0;i<arr.length;++i)
		{
			System.out.println("\n\nPlease create a point that "+arr[i]+" will move to");
			System.out.println("If point values are illegal animal will not move");
			System.out.println("Please enter X value:");
			System.out.println("NOTE: legal X values: "+Point.min_x+" - "+Point.max_x);
			
			x=sc.nextInt();
			
			System.out.println("Please enter Y value:");
			System.out.println("NOTE: legal Y values: "+Point.min_y+" - "+Point.max_y);
			
			y=sc.nextInt();
			
			p=new Point(x,y);
			if(Point.checkBoundaries(p))
				move(arr[i],p);
			else
				System.out.println("\nIllegal point values, animal has not moved\n");
			
		}
		
	}
	/**
	 * a method meant to create a lion object so it could be sent to animal array
	 * @return - Lion object created with user's input
	 */
	private static Lion createLion()
	{
		String n = createName();
		
		Point loc=createLocation(Lion.def_location);
		
		double w=createWeight(Lion.def_weight);
		
		int s;
		
		System.out.println("\nPlease enter number of scars of the lion (if it has any, not lower than 0)");
		System.out.println("NOTE: if out of range values are entered default scar number "+Lion.defScars+" will be entered");

		s=sc.nextInt();
		
		if(s<0)
			s=Lion.defScars;
		
		return new Lion(n,loc,w,s);
			
	}
	/**
	 * a method meant to create a bear object so it could be sent to animal array
	 * @return - Bear object created with user's input
	 */
	private static Bear createBear()
	{
		String n = createName();
		
		Point loc=createLocation(Bear.def_location);
		
		double w=createWeight(Bear.def_weight);
		
		int choice=0;
		
		String f;
		
		System.out.println("\nPlease enter a number to choose a fur color for the bear");
		System.out.println("Must be one of these options:");
		
		for(int i=0 ;i<Bear.furs.length;++i) 
			System.out.println((i+1)+". "+Bear.furs[i]);

		System.out.println("(Otherwise fur color will be default: "+Bear.defFur+" )");
		choice=sc.nextInt();
		
		if(choice<=0||choice>Bear.furs.length)
			f=Bear.defFur;
		else
			f=Bear.furs[choice-1];
		
		return new Bear(n,loc,w,f);
		
	}
	/**
	 * a method meant to create a Giraffe object so it could be sent to animal array
	 * @return - Giraffe object created with user's input
	 */
	private static Giraffe createGiraffe()
	{
		String n = createName();
		
		Point loc=createLocation(Giraffe.def_location);
		
		double w=createWeight(Giraffe.def_weight);
		
		double neck;
		
		System.out.println("\nPlease set neck length for the girrafe (must be within "+Giraffe.minNeckLength+" - "+Giraffe.maxNeckLength+" )");
		System.out.println("(Otherwise neck length will be default: "+Giraffe.defNeckLength+" )");
		
		neck = sc.nextDouble();
		
		return new Giraffe(n,loc,w,neck);
	}
	/**
	 * a method meant to create an Elephant object so it could be sent to animal array
	 * @return Elephant object created with user's input
	 */
	private static Elephant createElephant()
	{
		String n = createName();
		
		Point loc=createLocation(Elephant.def_location);
		
		double w=createWeight(Elephant.def_weight);
		
		double t;
		
		System.out.println("\nPlease set trunk length for the elephant (must be within "+Elephant.minTrunkLength+" - "+Elephant.maxTrunkLength+" )");
		System.out.println("(Otherwise trunk length will be default: "+Elephant.defTrunkLength+" )");
		
		t=sc.nextDouble();
		
		return new Elephant(n,loc,w,t);
	}
	/**
	 * a method meant to create a Turtle object so it could be sent to animal array
	 * @return Turtle object created with user's input
	 */
	private static Turtle createTurtle()
	{
		
		String n = createName();
		
		Point loc=createLocation(Turtle.def_location);
		
		double w=createWeight(Turtle.def_weight);
		
		int a;
		
		System.out.println("\nPlease set age the turtle (must be within "+Turtle.minAge+" - "+Turtle.maxAge+" )");
		System.out.println("(Otherwise age will be default: "+Turtle.defAge+" )");
		
		a=sc.nextInt();
		
		
		return new Turtle(n,loc,w,a);
	}
	
	/**
	 * a method meant to name animals
	 * @return - animal name (user's input)
	 */
	private static String createName()
	{
		String s;
		
		System.out.println("\nPlease create a name for the animal: ");
		
		s=sc.next();
		
		return s;
	}
	/**
	 * a method meant to create point for animal's location
	 * @param def - default location (different for each animal)
	 * @return - Point object with user's input or if illegal input - default Location
	 */
	private static Point createLocation(Point def)
	{
		int x;
		int y;
		
		System.out.println("\nPlease create a location for the animal");
		System.out.println("NOTE: if out of range values are entered default point "+def+" will be entered");
		
		System.out.println("Enter x value (within "+Point.min_x+"-"+Point.max_x+"):");
		x=sc.nextInt();
		
		System.out.println("Enter y value (within "+Point.min_y+"-"+Point.max_y+"):");
		y=sc.nextInt();
		
		Point p = new Point(x,y);
		
		if(Point.checkBoundaries(p))
			return p;
		
		return def;
	}
	/**
	 * a method meant to create weight for animal
	 * @param def - default weight (different for each animal)
	 * @return - weight with user's input or if illegal input - default weight
	 */
	private static double createWeight(double def)
	{
		double w;
		
		System.out.println("\nPlease set weight for the animal (should be around default value, not 0 or lower)");
		System.out.println("NOTE: if out of range values are entered default weight "+def+" will be entered");
		
		w = sc.nextDouble();
		
		if(w<=0)
			return def;
		else
			return w;
	}
	
	
	
	

}
