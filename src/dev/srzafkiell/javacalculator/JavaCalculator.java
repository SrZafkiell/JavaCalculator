/*
Java Calculator project.
Compiled using Java 21.
*/
package dev.srzafkiell.javacalculator;

import dev.srzafkiell.javacalculator.operations.*;

import java.util.Objects;
import java.util.Scanner;

public class JavaCalculator {

	/**
	 * Multidimensional array that stores the operands to be operated. <br>
	 * Scheme: [Operand value][Assignment status]. <br>
	 * Status: If the assignment status is zero (0), it means it hasn't been assigned. If it is one (1), it has been assigned.
	 */
	private final double[][] operandData = new double[2][2];

	public static void main(String[] args) {
		JavaCalculator javaCalculator = new JavaCalculator();
		javaCalculator.calculatorLoop();
	}

	/**
	 * Loop for the calculator menu
	 */
	private void calculatorLoop(){
		Scanner scanner = new Scanner(System.in);
		String message = "";
		double result;

		while (!message.equalsIgnoreCase("exit")) {

			System.out.println(whatToAskFor()); // This ask for what it should ask for in the console and prints it.
			message = scanner.nextLine(); // Reads the message to be analyzed by the calculator.

			/*
			 * If the first and second operand status is one (1).
			 * It would mean that we have the operands already to be operated, we can start reading the operation to be made.
			 */
			if (isFirstOperandNotSet() || isSecondOperandNotSet()){ // Check if both operands are not set and proceeds with the try and catch.

				try {
					if (isFirstOperandNotSet()){
						operandData[0][0] = Double.parseDouble(message); // Converts the number in the message to Double and stores it.
						setOperandAsEstablished(0); // Establish the operand one status as already set.
					} else if (isSecondOperandNotSet()) { // NOTE: I don't know why IntelliJ is telling me this is always true.
							operandData[1][0] = Double.parseDouble(message); // Converts the number in the message to Double and stores it.
							setOperandAsEstablished(1);	// Establish the operand two status as already set.
							continue;
					}
				} catch (NumberFormatException exception) {
					// We could add an error handling function here and remove this simple message to make it more "professional".
					// Will think about a better error handling method in the future.
					System.out.println("ERROR: " + message + " is not a number.");
				}
			}

			if (!isFirstOperandNotSet() && !isSecondOperandNotSet()) { // Check if both operands are now set and then proceeds with the try and catch.
				try {
					OperationType operationType = OperationType.fromSymbol(message); // Returns the operation type. Example: ADDITION.
					OperationType operation = getOperation(operationType); // Get the operation object for the operation type from above.
					result = operation.perform(operandData[0][0] , operandData[1][0]); // Now with the operands and the operation type, it gets the result.
					if (!Objects.equals(operationType.getName(), "Logarithm")){ // If the operation is not a logarithm, sends the normal message for the result, if it is, sends a different message.
						System.out.println("Operation " + operandData[0][0] + " " + operationType.getSymbol() + " " + operandData[1][0] + " = " + result); // Normal line
					} else {
						System.out.println(operationType.getSymbol() + " base " + operandData[1][0] + " of " + operandData[0][0] + " = " + result); // Logarithm line
					}
					System.out.println("Starting a new operation.");
					cleanOperands(); // Clean the operand array to continue with a new calculation.
				} catch (IllegalArgumentException exception){
					// We could add an error handling function here and remove this simple message to make it more "professional".
					// Will think about a better error handling method in the future.
					System.out.println("ERROR: " + "Unknown operation " + message);
				}
			}
		}
		System.out.println("You are leaving? I'm going back to the dark GitHub library for the eternity :(");
	}

	/**
	 * This method is to simplify the way the calculator asks for input.
	 * @return The correct string for the number or the operand needed.
	 */
	private String whatToAskFor(){
		if (isFirstOperandNotSet()){
			return "Please write the first operand";
		} else if (isSecondOperandNotSet()) {
			return "Please write the second operand";
		} else {
			return "Please write the operation you want to use: (+), (-), (*), (/), (%), (log) "; // Doesn't need to be case-sensitive.
		}
	}

	/**
	 * @return First operand set status
	 */
	private boolean isFirstOperandNotSet(){
		return operandData[0][1] != 1;
	}

	/**
	 * @return Second operand set status
	 */
	private boolean isSecondOperandNotSet(){
		return operandData[1][1] != 1;
	}

	/**
	 * Sets the given operand id as established in the system.
	 * @param operandNumber Operand id to be set as established. This is zero(0) for the first operand and one(1) for the second operand.
	 */
	private void setOperandAsEstablished(int operandNumber){
		operandData[operandNumber][1] = 1;
	}

	/**
	 * Travels through the operandData array and establish the old operands to zero, it also establishes the status as zero,
	 * it means that hasn't been assigned.
	 */
	private void cleanOperands(){
		for (int i = 0; i < operandData.length; i++) {
			operandData[i][0] = 0.0;
			operandData[i][1] = 0.0;
		}
	}

	/**
	 * @param operationType Given operation type, for example, "ADDITION".
	 * @return Object for the operation type given
	 */
	private OperationType getOperation(OperationType operationType){
		return switch (operationType) {
			case ADDITION -> OperationType.ADDITION;
			case SUBTRACTION -> OperationType.SUBTRACTION;
			case MULTIPLICATION -> OperationType.MULTIPLICATION;
			case DIVISION -> OperationType.DIVISION;
			case MODULE -> OperationType.MODULE;
			case LOG -> OperationType.LOG;
		};
	}
}

// There are a lot of comments and Javadocs in this o_O. My future me will HAVE to understand this again.