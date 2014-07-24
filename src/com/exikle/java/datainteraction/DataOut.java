package com.exikle.java.datainteraction;

import java.io.*;

public class DataOut {

	public static void main(String[] args) {
		new DataOut();
	}

	public DataOut() {
		saveFile();
	}

	public void saveFile() {
		PrintWriter out = null; // variable representing the PrintWriter
		String line = ""; // variable to read each line from the data file
		// Open the data file
		try {
			// in general we have substituted the word Writer for Reader
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					new File("DataFile1.txt"), true)), true);
			// add ,true parameter to the PrintWriter to FLUSH Buffer with every write line
			// add ,true parameter to the FileWriter for opening as APPEND
			System.out.println("File Opening");
		} catch (IOException e) {
			System.out.println("Problem opening File");
		}
		// line= (w/e you want to put in file)
		out.print("");
		out.println(line); // outputs the contents of the variable 'line' to the file
		out.close(); // Close the data file
		System.out.println("File Closing");
	}
}
