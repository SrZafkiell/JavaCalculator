package dev.srzafkiell.javacalculator.operations;

public class Division implements Operation {

	/**
	 * @throws IllegalArgumentException When the numberTwo equals to zero.
	 * @param numberOne First operand.
	 * @param numberTwo Second operand.
	 * @return Division of the first operand by the second operand.
	 */
	@Override
	public double perform(double numberOne, double numberTwo) {
		if (numberTwo == 0){
			throw new IllegalArgumentException("Can't divide by zero");
		}
		return numberOne / numberTwo;
	}
}
