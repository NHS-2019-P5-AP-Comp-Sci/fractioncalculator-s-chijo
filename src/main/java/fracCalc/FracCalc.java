/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {

		while (true) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Type \"quit\" to quit at any time. Add, subtract, multiply, or divide fractions: ");
			String input = userInput.nextLine(); // Takes user input
			if (input.equalsIgnoreCase("quit")) {
				System.exit(0); // Quits program based on user input
			} else {
				produceAnswer(input); //runs program based on user input
			}
		}

	}

	private static void While(boolean b) {
		// TODO Auto-generated method stub

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String values) {
		int space = values.indexOf(" ");
		String first = values.substring(0, space);
		String operator = values.substring(space + 1, space + 2);
		String second = values.substring(space + 3);
	
		
		int whole = whole(second);
		int numerator = numerator(second);
		int denominator = denominator(second);
		String numbers = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
		System.out.println(numbers);
		return(numbers);
	}
	public static int numerator(String input) {
		int firstUnderScore = input.indexOf('_');
		int divisionSymbol = input.indexOf('/');
		if (divisionSymbol == -1) {
			return 0;
		} else {
			String numerator = input.substring(firstUnderScore + 1, divisionSymbol);
			return Integer.parseInt(numerator);
		}
	}

	public static int denominator(String input) {
		int divisionSymbol = input.indexOf('/');
		if (divisionSymbol == -1) {
			return 1;
		} else {
			String denominator = input.substring(divisionSymbol + 1);
			return Integer.parseInt(denominator);
		}
		}
		public static int whole(String input) {
			int firstUnderScore = input.indexOf('_');
			int divisionSymbol = input.indexOf('/');
			if (firstUnderScore == -1 && divisionSymbol == -1) {
				return Integer.parseInt(input);
			} else if (firstUnderScore <= 0) {
				return 0;
			} else {
				String stringWholeNumber = input.substring(0, firstUnderScore);
				return Integer.parseInt(stringWholeNumber);
	}

		
	}

}