package dev.srzafkiell.javacalculator.operations;

public class Logarithm implements Operation {

	/**
	 * Logarithm calculation, the second number will be taken as the base.
	 * @param numberOne First operand.
	 * @param numberTwo Logarithm base.
	 * @return Result of the logarithm using the given operands.
	 */
	@Override
	public double perform(double numberOne, double numberTwo) {
		return Math.log(numberOne)/Math.log(numberTwo);
	}
}
