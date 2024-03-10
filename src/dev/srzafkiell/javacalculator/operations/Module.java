package dev.srzafkiell.javacalculator.operations;

public class Module implements  Operation{

	/**
	 * @param numberOne First operand.
	 * @param numberTwo Second operand.
	 * @return Residue of the division of the first operand and the second operand.
	 */
	@Override
	public double perform(double numberOne, double numberTwo) {
		return numberOne % numberTwo;
	}
}
