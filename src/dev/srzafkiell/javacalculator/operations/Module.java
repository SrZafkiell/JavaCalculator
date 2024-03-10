package dev.srzafkiell.javacalculator.operations;

public class Module implements  Operation{
	@Override
	public double perform(double numberOne, double numberTwo) {
		return numberOne % numberTwo;
	}
}
