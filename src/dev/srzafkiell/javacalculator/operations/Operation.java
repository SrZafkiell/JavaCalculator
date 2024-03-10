package dev.srzafkiell.javacalculator.operations;

public interface Operation {

	/**
	 * Interface function to perform operations. <br>
	 * @param numberOne First operand.
	 * @param numberTwo Second operand.
	 * @return Result of the selected operating using the first and second operand.
	 */
	default double perform(double numberOne, double numberTwo) {
		return 0;
	}
}
