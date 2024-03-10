package dev.srzafkiell.javacalculator.operations;

public class Division implements Operation {
	@Override
	public double perform(double numberOne, double numberTwo) {
		if (numberTwo == 0){
			throw new IllegalArgumentException("Can't divide by zero");
		}
		return numberOne / numberTwo;
	}
}
