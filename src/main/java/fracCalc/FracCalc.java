/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {

		while (true) {
			Scanner uservalue = new Scanner(System.in);
			System.out.println("Type \"quit\" to quit at any time. Add, subtract, multiply, or divide fractions: ");
			String values = uservalue.nextLine(); // Takes user values
			if (values.equalsIgnoreCase("quit")) {
				System.exit(0); // Quits program based on user values
			} else {
				produceAnswer(values); // runs program based on user values
			}
		}

	}

	private static void While(boolean b) {
		// TODO Auto-generated method stub

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'values' and produces the result
	//
	// values is a fraction string that needs to be evaluated. For your program,
	// this
	// will be the user values.
	// e.g. values ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"

	public static String produceAnswer(String values) {
		int space = values.indexOf(" ");
		String equation1 = values.substring(0, space);
		String symbol = values.substring(space + 1, space + 2);
		String equation2 = values.substring(space + 3);
		String two = negative(equation2);
		String one = negative(equation1);
		int numerator1 = Integer.parseInt(one.substring(0, one.indexOf('/')));
		int denominator1 = Integer.parseInt(one.substring(one.indexOf('/') + 1));
		int numerator2 = Integer.parseInt(two.substring(0, two.indexOf('/')));
		int denominator2 = Integer.parseInt(two.substring(two.indexOf('/') + 1));
		if (symbol.equals("-")) {
			String numerator = (numerator1 * denominator2) - (numerator2 * denominator1) + "";

			String denominator = denominator1 * denominator2 + "";
			String result = numerator + "/" + denominator;

			return result;

		} else if (symbol.equals("+")) {
			String numerator = (numerator1 * denominator2) + (numerator2 * denominator1) + "";

			String denominator = denominator1 * denominator2 + "";
			String result = numerator + "/" + denominator;

			return result;

		} else if (symbol.equals("*")) {
			String numerator = numerator1 * numerator2 + "";
			String denominator = denominator1 * denominator2 + "";
			String result = numerator + "/" + denominator;

			return result;

		} else {
			String numerator = numerator1 * denominator2 + "";
			String denominator = denominator1 * numerator2 + "";
			String result = numerator + "/" + denominator;

			return result;

		} 

		}
	
	public static String negative(String equation) {
		String wholeNum;
		String numerator;
		String denominator;
		if (equation.indexOf('_') != -1) {
			wholeNum = equation.substring(0, equation.indexOf('_'));
		} else if (equation.indexOf('/') != -1) {
			wholeNum = "0";
		} else {
			wholeNum = equation.substring(0, equation.length());
		}
		if (equation.indexOf('/') != -1) {
			numerator = equation.substring(equation.indexOf('_') + 1, equation.indexOf('/'));
			denominator = equation.substring(equation.indexOf('/') + 1);
		}
		else {
			numerator = "0";
			denominator = "1";
		}
		if (wholeNum.length() > 0) {
			if (wholeNum.substring(0, 1).equals("-")) {
				numerator = "-" + (Integer.parseInt(denominator) * Integer.parseInt(wholeNum.substring(1))
						+ Integer.parseInt(numerator));
			} else if (!wholeNum.substring(0, 1).equals("-")) {
				
				numerator = Integer.parseInt(denominator) * Integer.parseInt(wholeNum) + Integer.parseInt(numerator)
						+ "";
			}
		}
		return numerator + "/" + denominator;
	}
}