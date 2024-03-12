package dev.srzafkiell.javacalculator.operations;

public enum OperationType {

	ADDITION("+", "Addition"){
		/**
		 * @param numberOne First operand.
		 * @param numberTwo Second operand.
		 * @return The addition of the first and second operand.
		 */
		@Override
		public double perform(double numberOne, double numberTwo) {
			return numberOne + numberTwo;
		}
	},
	SUBTRACTION("-", "Subtraction"){
		/**
		 * @param numberOne First operand.
		 * @param numberTwo Second operand.
		 * @return Subtract the second operand from the first.
		 */
		@Override
		public double perform(double numberOne, double numberTwo) {
			return numberOne - numberTwo;
		}
	},
	MULTIPLICATION("*", "Multiplication"){
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
	},
	DIVISION("/", "Division"){
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
	},
	MODULE("%", "Module"){
		/**
		 * @param numberOne First operand.
		 * @param numberTwo Second operand.
		 * @return Residue of the division of the first operand and the second operand.
		 */
		@Override
		public double perform(double numberOne, double numberTwo) {
			return numberOne % numberTwo;
		}
	},
	LOG("log", "Logarithm"){
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
	};

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

	public abstract double perform(double numberOne, double numberTwo);
}