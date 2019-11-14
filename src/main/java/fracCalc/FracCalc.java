/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		
		while(true)	{
			Scanner userInput = new Scanner(System.in);
			System.out.println("Add, subtract, multiply, or divide fractions: ");
			String input = userInput.nextLine();
			
			produceAnswer(input);   
			System.out.println("If you want to quit now, just type in \"quit\" ");
			String exit = userInput.nextLine();     //Takes user input 
			
			if(exit.equals("quit")) { //Method for users to quit the program
				System.exit(0);     
	
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
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		int space = input.indexOf(" ");    
    	String first = input.substring(0 , space);    //The first operand from the user input
    	String operator = input.substring(space + 1, space + 2);    //The operator between the operands
    	String second = input.substring(space + 3);   //The second operand from the user input
   
    	
        return second; //returns the second operand
		
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
