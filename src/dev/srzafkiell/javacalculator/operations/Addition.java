package dev.srzafkiell.javacalculator.operations;

public class Addition implements Operation {
	@Override
	public double perform(double numberOne, double numberTwo) {
		return numberOne + numberTwo;
	}
}
