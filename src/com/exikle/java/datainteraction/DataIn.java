package com.exikle.java.datainteraction;

import java.io.*;

public class DataIn {

	public static void main(String[] args) {
		new DataIn();
	}

	public DataIn() {
		importFile();
	}

	public void importFile() {
		String[] fields; // array to store the "split" line read
		String fname = "", lname = ""; // individual field variables
		int jersey = 0; // individual field variable

		BufferedReader in = null; // variable representing the bufferedreader
		String line = "A B 1"; // variable to read each line from the data file
		File f = new File("DataFile1.txt"); // variable reprsenting the data
											// file

		// Open the data file
		try {
			in = new BufferedReader(new FileReader(f));
			System.out.println("File Opening");
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening File");
		}
		// Read each line and split to appropriate field variables
		while (line != null) {
			try {
				line = in.readLine();
				if (line != null) {
					fields = line.split(" ");
					fname = fields[0];
					lname = fields[1];
					jersey = Integer.parseInt(fields[2]);
				}
			} catch (IOException e) {
				System.out.println("Problem reading data from file");
			}
			if (line != null) {
				System.out.println(line);
				System.out.println(fname);
				System.out.println(lname);
				System.out.println("" + jersey);
			}
		}
		// Close the data file
		try {
			in.close();
			System.out.println("Closing File");
		} catch (IOException e) {
			System.out.println("Problem Closing " + e);
		}
	}
}
