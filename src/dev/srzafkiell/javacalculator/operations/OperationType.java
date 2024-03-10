package dev.srzafkiell.javacalculator.operations;

public enum OperationType {
	ADDITION("+", "Addition"),
	SUBTRACTION("-", "Subtraction"),
	MULTIPLICATION("*", "Multiplication"),
	DIVISION("/", "Division"),
	MODULE("%", "Module"),
	LOG("log", "Logarithm");

	private final String symbol;
	private final String name;

	OperationType(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public static OperationType fromSymbol(String symbol) {
		for (OperationType type : values()) {
			if (type.symbol.equals(symbol)) {
				return type;
			}
		}
		throw new IllegalArgumentException();
		// If we don't want to raise an error and let the program continue, > return null;
	}
}