package dev.srzafkiell.javacalculator.operations;

public class Subtraction implements Operation {

	/**
	 * @param numberOne First operand.
	 * @param numberTwo Second operand.
	 * @return Subtract the second operand from the first.
	 */
	@Override
	public double perform(double numberOne, double numberTwo) {
		return numberOne - numberTwo;
	}
}
