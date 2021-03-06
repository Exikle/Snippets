package com.exikle.java.inheritenum;

public class Snippet {

	public static void main(String[] args) {
		double x = Double.parseDouble("2");
		double y = Double.parseDouble("4");
		test(BasicOperation.class, x, y);
		test(ExtendedOperation.class, x, y);
	}

	private static <T extends Enum<T> & Operation> void test(
			Class<T> opSet, double x, double y) {
		for (Operation op : opSet.getEnumConstants())
			System.out.printf("%f %s %f = %f%n", x, op, y,
					op.apply(x, y));
	}
}
