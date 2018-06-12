package com.example.michael.lib;

import java.util.Set;
import java.util.TreeSet;

/**
 * to chang name, put blinking courser over class name and press shift + f6
 * you may rename this class to something more descriptive than NewClass
 * <p>
 * to get this commenting scheme, type /** before a class, method or data member
 * then hit enter
 */
class NewClass
{
	//notice, I used Integer, not int
	//in java, all things are objects, except primitive data types
	//Set takes in objects, so I gave it the Integer object
	private Set<Integer> primes;
	private int max;

	//this is a singleton, meaning that there will only be one of this object in
	//the project
	static private NewClass sNewClass;

	//to create getters/setters press alt + insert and make selection

	public static NewClass getsNewClass()
	{
		return sNewClass;
	}

	//however, I want a singleton getter to get the object
	public static NewClass get()
	{
		//sNewClass is a pointer to a NewClass object
		//if it hasn't been instantiated(constructed) yet
		//then do so
		if (sNewClass == null)
		{
			sNewClass = new NewClass();
		}
		return sNewClass;
	}

	//a singleton has a private constructor
	private NewClass()
	{
		//I have hardcoded the beginning of the primes
		primes = new TreeSet<>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		max = 5;
	}

	/**
	 * @param guess the number to check
	 * @return true if guess is prime, false otherwise
	 */
	public boolean isPrime(int guess)
	{
		if (guess < 1)
			return false;

		constructPrimes(guess);

		if (primes.contains(guess))
			return true;

		return false;
	}

	private void constructPrimes(int newMax)
	{

		//if it already is in the list or less than what
		//we've already gone through, then we should figure
		//it shouldn't be computed again
		if (newMax < max || primes.contains(newMax))
			return;

		if(newMax > 500000)
			System.out.println(">.> this may take a while");

		while(max <= newMax)
		{
			max += 2;
			boolean isPrime = true;
			for(int prime:primes)
			{
				if(max % prime == 0)
				{
					isPrime = false;
				}
				if(!isPrime)
					break;
			}
			if (isPrime)
				primes.add(max);
		}
	}
}
