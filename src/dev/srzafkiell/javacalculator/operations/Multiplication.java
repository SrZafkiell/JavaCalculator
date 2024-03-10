package dev.srzafkiell.javacalculator.operations;

public class Multiplication implements Operation {

	/**
	 *
	 * @param numberOne First operand.
	 * @param numberTwo Second operand.
	 * @return Multiplication of the first operand with the second operand.
	 */
	@Override
	public double perform(double numberOne, double numberTwo) {
		return numberOne * numberTwo;
	}
}
