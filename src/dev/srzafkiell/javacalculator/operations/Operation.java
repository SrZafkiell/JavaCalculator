package dev.srzafkiell.javacalculator.operations;

public interface Operation {
	default double perform(double numberOne, double numberTwo) {
		return 0;
	}
}
