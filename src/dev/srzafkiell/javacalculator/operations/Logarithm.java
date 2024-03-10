package dev.srzafkiell.javacalculator.operations;

public class Logarithm implements Operation {
	@Override
	public double perform(double numberOne, double numberTwo) {
		return Math.log(numberOne)/Math.log(numberTwo);
	}
}
