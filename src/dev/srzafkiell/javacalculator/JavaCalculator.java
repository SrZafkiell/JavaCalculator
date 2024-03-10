package dev.srzafkiell.javacalculator;

import dev.srzafkiell.javacalculator.operations.*;
import dev.srzafkiell.javacalculator.operations.Module;

import java.net.SocketAddress;
import java.util.Scanner;

public class JavaCalculator {

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
		double result = 0;

		while (!message.equalsIgnoreCase("exit")) {
			message = scanner.nextLine();

			try {
				OperationType operationType = OperationType.fromSymbol(message);
				System.out.println(operationType.getName());
				Operation operation = getOperation(operationType);
				result = calculate(operation, 5 , 10);
				System.out.println(result);

			} catch (IllegalArgumentException exception){
				System.out.println("Unknown operation: " + message);
			}
		}
		System.out.println("You are leaving? I'm going back to the dark GitHub library for the eternity :(");
	}

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