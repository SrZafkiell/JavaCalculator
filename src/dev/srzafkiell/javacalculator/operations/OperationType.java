package dev.srzafkiell.javacalculator.operations;

public enum OperationType {

	ADDITION("+", "Addition"),
	SUBTRACTION("-", "Subtraction"),
	MULTIPLICATION("*", "Multiplication"),
	DIVISION("/", "Division"),
	MODULE("%", "Module"),
	LOG("log", "Logarithm");

	/**
	 * Representing symbol for the operations -> "+", "-", "*", "/", "%", "Log".
	 */
	private final String symbol;
	/**
	 * Name of the operation -> Addition, Subtraction, Multiplication, Division, Module, Logarithm.
	 */
	private final String name;

	/**
	 * Constructor for the operation type
	 * @see #symbol
	 * @param symbol Symbol that represents the operation
	 * @param name Name of the operation
	 */
	OperationType(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	/**
	 * @return Symbol of the operation
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @return Name of the operation
	 */
	public String getName() {
		return name;
	}

	/**
	 * Checks if the symbol given matches one on enum, and if it does return its type.
	 * @param symbol Symbol to be checked.
	 * @return Type of the operation.
	 * @throws IllegalArgumentException When the symbol is not an available operation.
	 */
	public static OperationType fromSymbol(String symbol) {
		for (OperationType type : values()) {
			if (type.symbol.equals(symbol.toLowerCase())) {
				return type;
			}
		}
		throw new IllegalArgumentException();
		// If we don't want to raise an error and let the program continue, > return null;
	}
}