package com.example.michael.lib;

/**
 * to run, press  ctr + shift + f10
 * in the top right corner, on the dropdown menu that says MyClass with a
 * green arrow and hammer next to it, click on the down arrow then on the drop down menu click
 * "save 'MyClass' Configuration"
 * to run again, click the green arrow
 */
public class MyClass
{
	public static void main(String args[])
	{

		System.out.println("Hello, World!");

		//if you don't like my coding style, press Ctr + alt + l
		// and watch the magic

		//if you go back to where you saved the configuration
		//there should be an "Edit Configurations" button
		//click on that and with MyClass selected, look for
		//"program arguments" and type in whatever you want
		//and then click the "OK" button, then the green arrow button
		if (args.length > 0)
			System.out.println(isArgPrime(args[0]));
	}

	/**
	 * change this so we can keep asking it if other numbers are prime
	 * and exits when "exit" is typed
	 *
	 * @param guess
	 * @return response to the argument as to whether the argument is prime or not
	 */
	private static String isArgPrime(String guess)
	{
		//we use StringBuilder because they say it's better... or something... efficient-er
		//don't worry, it's easy to use
		StringBuilder s = new StringBuilder();
		s.append("is ");
		s.append(guess);
		s.append(" prime?\n");

		//with strings, we can use regular expressions (regex) to see if it isn't a number
		//just so we can force the use of numbers from user.
		if (!guess.matches("[0-9]*"))
		{
			s.append(guess);
			s.append(" is not a number\n");
			return s.toString();
		}

		//in Java, (and you can in c++) instantiate your variables where
		//you use/need them// where it makes sense
		int potentialPrime = Integer.parseInt(guess);

		NewClass newClass = NewClass.get();

		s.append(potentialPrime);
		s.append(" is ");
		if (!newClass.isPrime(potentialPrime))//this is where the magic happens
			s.append("not ");
		s.append("prime");

		return s.toString();
	}

}
