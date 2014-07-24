package com.exikle.java.datainteraction;

import java.io.File;

public class ListFiles {

	public static void main(String[] args) {
		// Directory path here
		String path = ".";

		String files;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		// String[] filename;
		// NotesTop.list=new JLabel[listOfFiles.length];
		String[] filename = new String[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".txt") || files.endsWith(".TXT")) {
					System.out.println(listOfFiles[i].getName());
					filename[i] = listOfFiles[i].getName();
					// System.out.println(files);
				}
			}
		}
	}
}