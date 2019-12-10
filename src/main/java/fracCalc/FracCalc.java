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

	public static String produceAnswer(String equation) {
// Parses operator and operand
		int space = equation.indexOf(' ');
		String operand1 = equation.substring(0, space);
		String operator = equation.substring(equation.indexOf(" ") + 1, space + 2);
		String operand2 = equation.substring(space + 3);

// Parses numerator, denominator
		String one = operandSeg(operand1);
		int num1 = Integer.parseInt(one.substring(0, one.indexOf('/')));
		int den1 = Integer.parseInt(one.substring(one.indexOf('/') + 1));
		String two = operandSeg(operand2);
		int num2 = Integer.parseInt(two.substring(0, two.indexOf('/')));
		int den2 = Integer.parseInt(two.substring(two.indexOf('/') + 1));

// For adding
		if (operator.equals("+")) {
			String num = (num1 * den2) + (num2 * den1) + "";
			String den = den1 * den2 + "";
			String answer = num + "/" + den;
			return simplify(answer);

// For subtracting
		} else if (operator.equals("-")) {
			String num = (num1 * den2) - (num2 * den1) + "";
			String den = den1 * den2 + "";
			String answer = num + "/" + den;
			return simplify(answer);

// For dividing
		} else if (operator.equals("/")) {
			if (num1 == 0 || den1 == 0 || num2 == 0 || den2 == 0)
				return "0";
			String num = num1 * den2 + "";
			String den = den1 * num2 + "";
			String answer = num + "/" + den;
			return simplify(answer);

// For multiplying
		} else if (operator.equals("*")) {
			if (num1 == 0 || den1 == 0 || num2 == 0 || den2 == 0)
				return "0";
			String num = num1 * num2 + "";
			String den = den1 * den2 + "";
			String answer = num + "/" + den;
			return simplify(answer);

		} else {
			return "ERROR: invalid format.";
		}

	}

	public static String operandSeg(String operand) {
// Sets equation as a string
		String whole;
		String num;
		String den;

// To whole number if it is mixed number
		if (operand.indexOf('_') != -1) {
			whole = operand.substring(0, operand.indexOf('_'));
		}
// Sets whole to 0 if number is fraction
		else if (operand.indexOf('/') != -1) {
			whole = "0";
		}

		else {
			whole = operand.substring(0, operand.length());
		}

// Sets num and den if operand is a fraction
		if (operand.indexOf('/') != -1) {
			num = operand.substring(operand.indexOf('_') + 1, operand.indexOf('/'));
			den = operand.substring(operand.indexOf('/') + 1);
		}
// Sets numerator and denominator if answer is a whole
		else {
			num = "0";
			den = "1";
		}

//Converts to mixed number
		if (whole.length() > 0) {
			if (whole.substring(0, 1).equals("-")) {
				num = "-" + (Integer.parseInt(den) * Integer.parseInt(whole.substring(1)) + Integer.parseInt(num));
			} else if (!whole.substring(0, 1).equals("-")) {
				num = Integer.parseInt(den) * Integer.parseInt(whole) + Integer.parseInt(num) + "";
			}
		}
		return num + "/" + den;
	}

	public static String simplify(String equation) {
// Parses into numerator, denominator, and whole
		int num = Integer.parseInt(equation.substring(0, equation.indexOf("/")));
		int den = Integer.parseInt(equation.substring(equation.indexOf("/") + 1));
		int whole = num / den;

// Negative placeholder
		if ((num < 0 && den < 0) || (num > 0 && den < 0)) {
			num /= -1;
			den /= -1;
		}

// simplifies outputs equal to 0
		if (num == 0 || den == 0)
			return "0";

// finds and divides by common den
		for (int i = Math.abs(den); i > 0; i--) {
			if ((num % i == 0) && (den % i == 0)) {
				num = num / i;
				den = den / i;
			}
		}

		if (den == 1) {
			return num + "";

		} else if (num % den == 0 && den != 0) {
			return (num / den) + "";
		}

		else {
			num = num - (whole * den);
			if (whole == 0) {
				return num + "/" + den;
			} else {
				if (whole < 0 && den < 0)
					den /= -1;
				else if (whole < 0 && num < 0)
					num /= -1;
				return "" + whole + "_" + num + "/" + den;
			}
		}

	}
}