package dev.srzafkiell.javacalculator.operations;

public class Addition implements Operation {

	/**
	 * @param numberOne First operand.
	 * @param numberTwo Second operand.
	 * @return The addition of the first and second operand.
	 */
	@Override
	public double perform(double numberOne, double numberTwo) {
		return numberOne + numberTwo;
	}
}
