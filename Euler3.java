/*
Welcome to Patrick Flaherty's Euler3 program
March 4, 2018
Euler3: Largest Prime Factors

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600,851,475,143 ?

Prime: The only factors of a given whole number are 1 and itself
*/

import java.*;
import java.util.*;

public class Euler3{

	Scanner keyIn = new Scanner(System.in); //Scanner object that we will use to get the input from the user.
	long input; //This is the input from the user
	int powers2;
	long temp;
	long [] factors;
	boolean done;
	long mult = 1;
	boolean tempb;
	boolean isPrime;
	double sTime = System.nanoTime();

	//This is a two line main, I do these a lot, Could be done in one line by creating a second main method with inputs but I dont like that very much.
	public static void main(String [] args){
		//System.out.println("In Main");
		Euler3 E = new Euler3();
		E.start();
	}
	
	
	//This is the method that will be utilized to begin the program from a dynamic source: The Euler3 Object "E" we made in the main method.
	public void start(){
	/*
		We are attempting to determine the largest prime numbers of a given integer;
		To start we will discuss special cases:
			We want to see if the number given is prime first, that would make our math easy.
			0 is not prime, so we must make sure to make a special case for input: 0
			1 is not prime either, This is by definition, it is however a factor that is always included so we will choose instead to just ignore 1.
			2 is prime, it is the only even prime number. As such we can check if the number is prime by (n%2). 
			All even numbers have a largest prime factor of 
		Using 13195 as an example we can identify patterns in the numbers
			any number that ends in 5 or 0 (excluding 0) is a multiple of 5, and therefore 5 is a prime factor of the number. 
			It will also be a largest prime factor, since no multiple of 5 is prime.
		Also, since 2 is the smallest prime integer, we can use that as a baseline to determine how many factors we may have.
			E.g. The prime factors of 13195 are 5,7,13,29. 13195 < 2^11 and has less than 11 factors. Wikipedia has a page of largest prime factors,
			by reading through this wikipedia page you can see that there are no numbers with more factors than the respective power of 2.
		Multiplicity is a significant concern.
	*/
	//System.out.println("In Start");
	System.out.println("Welcome to Euler 3: Largest Prime Factor");
	System.out.println("This algorithm will determine the largest prime factors of an integer you input.");
	System.out.println("Please enter your number: ");
	input = keyIn.nextLong(); //We will now read in the long integer that the user has sent us.
	if(input <= 1)
		special();
	powers(); //powers2 is now the power of 2 that is next greater than the input. e.g. input 31 would give us powers2 = 5
	factors = new long[powers2];
	//pop(); //populate factors with 1's
	doMath(); //Now that we have setup our algorithm, we should do the math
	printFactors();
	exit();
	}
	
	public void printFactors(){
		long checker = 1;
		System.out.print("The factors of " + input + " are:");
		for(int i = 0; i < factors.length; i++)
		{
			if(factors[i] != 0)
			{
				System.out.print(" " + factors[i]);
				checker = checker*factors[i];
			}
		}
		System.out.println();
		System.out.println("The Multiple of these numbers is: " + checker);
		System.out.println("And the largest prime factor of this number is " + factors[factors.length()-1])
	}
	
	//This method will do the meat of our Algorithm, we want to determine the largest prime factors of our input.
	public void doMath(){
		//One possible way we could do this is by multiplying all the numbers in our factors array. This would serve as a check to determine if our array
		//has all the largest prime factors of the number.
		//We also know that no prime factor can be larger than half the input, unless the input is prime.
		//System.out.println("In doMath");
		int loc = 0;
		long newNum = input;
		while(newNum > 1) //We want to be in this statement if we have a number greater than 1, this means that it has more factors to divide by.
		{
			for(long i = 2; i<=newNum; i++)
			{
				//First we want to check to see if i is a prime integer.
				isPrime = checkPrime(i);
				if(isPrime)
				{
					if(newNum%i == 0)
					{
						factors[loc] = i;
						newNum = newNum/i;
						i--;
						loc++;
					}
				}
			}
		}
	}
	
	
	//This method will check if thing is prime
	public boolean checkPrime(long thing)
	{
		tempb = true;
		if(thing == 2)
			return true;
		for(int i = 2; i < thing; i++)
		{
			if(thing%i == 0)
				return false; //This line makes this program much faster. return false is much better than tempb = false as the return cuts the method short
		}
		return tempb;
	}
	
	//This method will determine the next greatest power of 2 to the input we have been given. This is important in determining the maximum number of prime factors a number could ahve
	public void powers(){
		//System.out.println("In powers");
		temp = input;
		powers2 = 1;
		while(temp >= 2)
		{
			temp = temp/2;
			powers2++;
		}
	}
	
	
	
	//This method handles special cases of our algorithm
	public void special(){
		//System.out.println("In special");
		//special cases: negative numbers, 0, 1
		if(input < 0)
			System.out.println(input + " is a negative number; this algorithm does not handle negative numbers.");
		if(input == 0)	
			System.out.println("0 is a funky number, and we can not determine a largest prime factor.");
		if(input == 1)
			System.out.println("1 is a funky number, 1 is not prime, so 1 has no prime factors.");
		exit();//pass the program counter to exit so that we do not unnecessarily run the rest of the program.
	}
	
	public void exit(){
		double eTime = System.nanoTime();
		System.out.println("This algorithm took " + (eTime-sTime*0.000001) + " ms");
		//System.out.println("In exit");
		System.out.println("Thank you for using Patrick Flaherty's Euler3");
		System.out.println("I hope that this has been satisfactory");
		System.exit(0);		
	}
} //9 --> 16, factors[1,1,1,1] --> factors[2,2,2,1] --> factors[2,3,5,7]