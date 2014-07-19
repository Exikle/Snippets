package com.exikle.java.inheritenum;

public enum BasicOperation implements Operation {
	PLUS("+") {

		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {

		public double apply(double x, double y) {
			return x - y;
		}
	},
	MULTIPLY("*") {

		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {

		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	BasicOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}