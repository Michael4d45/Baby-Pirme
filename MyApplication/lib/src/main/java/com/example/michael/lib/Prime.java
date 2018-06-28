package com.example.michael.lib;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * to chang name, put blinking courser over class name and press shift + f6
 * you may rename this class to something more descriptive than Prime
 * <p>
 * to get this commenting scheme, type /** before a class, method or data member
 * then hit enter
 */
public class Prime {
    //notice, I used Integer, not int
    //in java, all things are objects, except primitive data types
    //Set takes in objects, so I gave it the Integer object... because java
    private Set<Integer> primes;

    //this is the max number that we've checked so far
    //that way we don't have redundant checkings
    private int max;

    //this is a singleton, meaning that there will only be one of this object in
    //the project
    static private Prime sPrime;

    //to create getters/setters press alt + insert and make selection

    //however, I want a singleton getter to get the object
    public static Prime get() {
        //sPrime is a pointer to a Prime object
        //if it hasn't been instantiated(constructed) yet
        //then do so
        if (sPrime == null) {
            sPrime = new Prime();
        }
        return sPrime;
    }

    //a singleton has a private constructor
    private Prime() {
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
    public boolean isPrime(int guess) {
        if (guess < 1)
            return false;

        constructPrimes(guess);

        if (primes.contains(guess))
            return true;

        return false;
    }

    /**
     * this constructs primes up to a new maximum number
     * it works by checking the numbers with modulo against all other prime numbers
     *
     * @param newMax the new maximum number
     */
    private void constructPrimes(int newMax) {

        //if it already is in the list or less than what
        //we've already gone through, then we should figure
        //it shouldn't be computed again
        if (newMax < max || primes.contains(newMax))
            return;

        long first = new Date().getTime();

        while (max <= newMax) {
            //this skips even numbers, that is if we start on an odd number
            max += 2;

            //this cuts off much time
            int sqrt = (int) Math.sqrt(max);

            boolean isPrime = true;
            for (int prime : primes) {
                if (max % prime == 0) {
                    isPrime = false;
                }
                if (!isPrime || prime > sqrt)
                    break;
            }
            if (isPrime)
                primes.add(max);
        }

        long last = new Date().getTime();

        float time = (last - first);
        time /= 1000;
        System.out.println(time + " seconds");
    }


    /**
     * change this so we can keep asking it if other numbers are prime
     * and exits when "exit" is typed
     *
     * @param guess
     * @return response to the argument as to whether the argument is prime or not
     */
	public String isArgPrime(String guess) {
        //we use StringBuilder because they say it's better... or something... efficient-er
        //don't worry, it's easy to use
        StringBuilder s = new StringBuilder();

        //with strings, we can use regular expressions (regex) to see if it isn't a number
        //just so we can force the use of numbers from user.
        if (!guess.matches("[0-9]*")) {
            s.append(guess);
            s.append(" is not a number");
            return s.toString();
        }

        //in Java, (and you can in c++) instantiate your variables where
        //you use/need them// where it makes sense
		int potentialPrime = 0;
		try
		{
			potentialPrime = Integer.parseInt(guess);
		}catch (NumberFormatException e)
		{
			s.append("bad input, try again");
			return s.toString();
		}

        s.append(potentialPrime);
        s.append(" is ");
        if (!isPrime(potentialPrime))//this is where the magic happens
            s.append("not ");
        s.append("prime");

        return s.toString();
    }
}
