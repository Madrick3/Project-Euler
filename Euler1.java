/*
Patrick Flaherty
pdf2@pitt.edu
March 2 - March 3, 2018
This is Euler Problem 1:

MULTIPLES OF 3 and 5:
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.

We will do this problem one better and make it so that we determine the sum of all the multiples
up to a value n input by the user.

This is a fairly easy Euler problem, to make it more significant I have included information such as the time each method takes to complete, whether or not there was
overflow, and also a comparison between the different methods.

*/

import java.util.*;
import java.*;

public class Euler1{
	int Euler; //This will be the number that the user inputs as the maximum integer.
	Scanner keyIn = new Scanner(System.in); //We make a scanner so that we can read the input form the user. 
		//This scanner only is used to read the Euler number
	int sum = 0; //this integer is the sum of all the integers that we are looking at
	double startTime; //this float will be used to determine the time it takes to do the counting
	double endTime; //this float is utilized like startTime. We will use these floats to compare strategies.
	double difference;
	int num30s = 0;
	double time1;
	double time2;
	double time3;
	
	
	public static void main(String [] args)
	{
		Euler1 E = new Euler1();
		E.start();
	}
	
	//This method will reset important values, this makes sure there is no carry over between methods. We will use this in between methods.
	public void reset()
	{
		sum = 0;
		startTime = 0;
		endTime = 0;
		difference = 0;
		
	}
	
	//This method is meant to intiialize the Euler number and ask the user what integer they want to use
	public void start()
	{
		System.out.println("Welcome to Euler1: 'Multiples of 3s and 5s'"); //Print the introduction of the program
		System.out.println("Please enter your Euler number: "); //Print the request to the user
		Euler = keyIn.nextInt(); //Euler will now be the next integer found in the Scanner. The user may not enter an integer but we dont particularly care about that
		System.out.println("Starting method 1");
		math1();
		reset();
		System.out.println("Starting Method 2");
		math2();
		reset();
		math3();
		compare();
		System.out.println("I hope that this was satisfactory");
	}
	
	//In this method, we will go through each integer (1, Euler) to determine if the value is a multiple of 3 or 5, and then add that number to the sum
	//This method is the simple way of doing this. It is slower than other methods but it would work
	public void math1() 
	{
		startTime = System.nanoTime();
		//System.out.println("StartTime is " + startTime);
		for(int i=1;i<Euler;i++)
		{
			if(i%3 == 0 || i%5 == 0) //This statement should be true if i is a multiple of 3 or 5
			{
				//System.out.println("//Adding " + i + " to the sum");
				sum = sum + i;
			}
		}
		endTime = System.nanoTime();
		//System.out.println("endTime is " + endTime);
		difference = (endTime-startTime) * 0.000001; //this gives us the difference in ms
		//System.out.println("We have finished iterating from 1 to " + Euler);
		System.out.println("The determined sum is: " + sum);
		if(sum<=0 && Euler > -1)
			System.out.println("We have detected overflow in the system");
		System.out.println("This took " + difference + " ms");
		time1 = difference;
	}
	
	public void math2()
	{
		//This method should be somewhat faster than the previous method. With such simple methods however these are not significant differences.
		//In this method we will add the multiples of 3 which are less than the Euler number, and then add the multiples of 5 that we have not counted.
		startTime = System.nanoTime();
		for(int i=3; i < Euler; i+=3)
		{
			sum = sum + i;
		}
		for(int i=5; i<Euler; i+=5)
		{
			if(i%3 != 0)
				sum = sum + i;
		}
		endTime = System.nanoTime();
		//System.out.println("endTime is " + endTime);
		difference = (endTime-startTime) * 0.000001; //this gives us the difference in ms
		//System.out.println("We have finished iterating from 1 to " + Euler);
		System.out.println("The determined sum is: " + sum);
		if(sum<=0 && Euler > -1)
			System.out.println("We have detected overflow in the system");
		System.out.println("This took " + difference + " ms");
		time2 = difference;
	}
	
	
	//math2 is already significantly faster than math1, but we may be able to make the function even faster
	//multiples of 3 and 5 occur in this patter: 3,5,3,3,5,3,35,3,5,3,3,5,3,35
	//This occurs for every 30 numbers, if we take Euler-1, and divide by 30
	//we will get the number of these repetitions that we go through(and determine if we have an extra amount)	
	public void math3()
	{
		startTime = System.nanoTime();
		num30s = (Euler-1)/30;
		//System.out.println("num30s is " + num30s);
		if(num30s > 0)
			for(int i = 1; i <= num30s; i++)
				sum = sum + 225 + 14*30*(i-1);
		//System.out.println("Sum is currently " + sum);
		for(int i = num30s*30+3; i<Euler;i++)
		{
			if(i%3 == 0 || i%5 == 0)
			{	sum = sum + i;
				//System.out.println("Adding i = " + i);
			}
		}
		endTime = System.nanoTime();
		
		difference = (endTime-startTime) * 0.000001; //this gives us the difference in ms
		//System.out.println("We have finished iterating from 1 to " + Euler);
		System.out.println("The determined sum is: " + sum);
		if(sum<=0 && Euler > -1)
			System.out.println("We have detected overflow in the system");
		System.out.println("This took " + difference + " ms");
		time3 = difference;
	}
	
	public void compare()
	{
		System.out.println("We are now comparing the results from each method.");
		if(time1 <= time2 && time1 <= time3)
			System.out.println("Method 1 Is the fastest; It took " +(time1/time2)+ " as much as time as method 2 and " + (time1/time3) + " as much time as method 3");
		if(time2 <= time1 && time2 <= time3)
			System.out.println("Method 2 Is the fastest; It took " +(time2/time1)+ " as much as time as method 1 and " + (time2/time3) + " as much time as method 3");
		if(time3 <= time2 && time3 <= time1)
			System.out.println("Method 3 Is the fastest; It took " +(time3/time1)+ " as much as time as method 1 and " + (time3/time2) + " as much time as method 2");
	}
	
/*
	After testing and comparing, we see that method 2 tends to be the fastest method, unless we enter a large value for Euler (think above 100) in which method 3 will be faster
	
	Something we could add in the future is a way to translate the overflow integer and increase the range of our inputs.
*/
	
	
	
}