/*
Java Calculator project.
Compiled using Java 21.
*/
package dev.srzafkiell.javacalculator;

import dev.srzafkiell.javacalculator.operations.*;
import dev.srzafkiell.javacalculator.operations.Module;

import java.util.Objects;
import java.util.Scanner;

public class JavaCalculator {

	/**
	 * Multidimensional array that stores the operands to be operated. <br>
	 * Scheme: [Operand value][Assignment status]. <br>
	 * Status: If the assignment status is zero (0), it means it hasn't been assigned. If it is one (1) it has been assigned.
	 */
	private final double[][] operandData = new double[2][2];

	public double calculate(Operation operation, double numberOne, double numberTwo){
		return operation.perform(numberOne, numberTwo);
	}

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
			message = scanner.nextLine();

			/*
			 * If the first and second operand status is one (1).
			 * It would mean that we have the operands already to be operated, we can start reading the operation to be made.
			 */
			if ((operandData[0][1] == 0) || (operandData[1][1] == 0)){
				try {
					if (operandData[0][1] == 0){
						operandData[0][0] = Double.parseDouble(message); // Converts the number in the message to Double and stores it.
						operandData[0][1] = 1; // Establish the operand one status as already set.
					} else {
						if (operandData[1][1] == 0) {
							operandData[1][0] = Double.parseDouble(message); // Converts the number in the message to Double and stores it.
							operandData[1][1] = 1; // Establish the operand two status as already set.
							continue;
						}
					}
				} catch (NumberFormatException exception) {
					System.out.println(message + " is not a number.");
				}
			}

			if ((operandData[0][1] == 1) && (operandData[1][1] == 1)) {
				try {
					System.out.println("Please write the operation you want to use: (+), (-), (*), (/), (%), (log) "); // Doesn't need to be case-sensitive.
					OperationType operationType = OperationType.fromSymbol(message); // Returns the operation type. Example: ADDITION.
					Operation operation = getOperation(operationType); // Get the operation object for the operation type from above.
					result = calculate(operation, operandData[0][0] , operandData[1][0]); // Now with the operands and the operation type, it gets the result.
					if (!Objects.equals(operationType.getName(), "Logarithm")){ // If the operation is not a logarithm, sends the normal message for the result, if it is, sends a different message.
						System.out.println("Operation " + operandData[0][0] + " " + operationType.getSymbol() + " " + operandData[1][0] + " = " + result); // Normal line
					} else {
						System.out.println(operationType.getSymbol() + " base " + operandData[1][0] + " of " + operandData[0][0] + " = " + result); // Logarithm line
					}
					System.out.println("Starting a new operation.");
					cleanOperands(); // Clean the operand array to continue with a new calculation.
				} catch (IllegalArgumentException exception){
					System.out.println("Unknown operation: " + message);
				}
			}
		}
		System.out.println("You are leaving? I'm going back to the dark GitHub library for the eternity :(");
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
	private Operation getOperation(OperationType operationType){
		return switch (operationType) {
			case ADDITION -> new Addition();
			case SUBTRACTION -> new Subtraction();
			case MULTIPLICATION -> new Multiplication();
			case DIVISION -> new Division();
			case MODULE -> new Module();
			case LOG -> new Logarithm();
		};
	}
}