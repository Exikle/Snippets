package com.exikle.java.calculators;

/*
 * propertyTaxes.java
 * Dixon D'Cunha
 * 10/2/12
 * ICS 4U1
 */
import java.util.Scanner;

public class PropertyTaxes {

	Scanner input = new Scanner(System.in);

	/**
	 * Calculate the property taxes of single and multi family residences.
	 */
	final double singleFamTaxRate = 1.004;

	final double singleFamRecycle = 20.00;

	final double multiFamTaxRate = 1.054;

	final double multiFamRecycle = 500.00;

	double outputPropertyTax;

	Boolean houseType = true;

	public static void main(String[] args) {
		new PropertyTaxes();
	}

	public PropertyTaxes() {
		System.out.print("Enter your house property value: ");
		double propertyValue = (input.nextDouble()) / 100;
		System.out
				.print("Is your house a single-family residence or a multi-family residence? (1 OR 2): ");
		int houseTypeInt = input.nextInt();
		if (houseTypeInt == 1)
			houseType = true;
		else if (houseTypeInt == 2)
			houseType = false;

		if (houseType == true) {
			outputPropertyTax = (propertyValue * singleFamTaxRate)
					+ singleFamRecycle;
			System.out
					.println("For your single-family house, the property tax is: $"
							+ outputPropertyTax);
		} else if (houseType == false) {
			outputPropertyTax = (propertyValue * multiFamTaxRate)
					+ multiFamRecycle;
			System.out
					.println("For your multi-family house, the property tax is: $"
							+ outputPropertyTax);
		}
	}
}
