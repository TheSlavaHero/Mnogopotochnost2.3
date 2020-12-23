package com.gmail.theslavahero;

import java.io.File;

public class Task3NewThread extends Thread{
	private File folder;
	private File fileToSearch;

	public Task3NewThread(File folder, File fileToSearch) {
		super();
		this.folder = folder;
		this.fileToSearch = fileToSearch;
	}

	public Task3NewThread() {
		super();
	}

	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	public File getFileToSearch() {
		return fileToSearch;
	}

	public void setFileToSearch(File fileToSearch) {
		this.fileToSearch = fileToSearch;
	}

	public void run() {
		File[] fileNames = folder.listFiles();
		try {
			for(int i = 0; fileNames[i].exists(); i++) {
				if (fileNames[i].isDirectory()) {
					try {
						Task3NewThread thread = new Task3NewThread(fileNames[i], fileToSearch);
						thread.start();
						thread.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (fileNames[i].isFile() && fileNames[i].getName().equals(fileToSearch.getName())) {
					System.out.println(fileToSearch.getAbsolutePath());
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Search in folder //" + this.folder.getName() + "// has been done.");
		}
	}
	
	@Override
	public String toString() {
		return "Task3NewThread [folder=" + folder + ", fileToSearch=" + fileToSearch + "]";
	}

}
