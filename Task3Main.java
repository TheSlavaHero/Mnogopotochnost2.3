package com.gmail.theslavahero;

import java.io.File;

public class Task3Main {

	public static void main(String[] args) {
		File folder = new File("C:\\Users\\slava\\eclipse-workspace\\Mnohopotok2\\search");
		File fileToSearch = new File("file.txt");
		File[] fileNames = folder.listFiles();

		try {
			Task3NewThread thread = new Task3NewThread(folder, fileToSearch);
			thread.start();
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
	}

}
