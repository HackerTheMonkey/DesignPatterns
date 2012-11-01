package com.example.designpatterns.memento;

import java.io.*;

/**
 * This class is designed using the singleton design
 * pattern
 */
public class FileUtils 
{
	private static FileUtils singleton;
	
	public int getFileRecordsCount(File file) throws IOException {				
		int count = 0;	
		BufferedReader bufferedReader = getBufferedReaderForFile(file);
		while(bufferedReader.readLine() != null) count++;

		return count;
	}
	
	private BufferedReader getBufferedReaderForFile(File file) throws FileNotFoundException {
		return new BufferedReader(new FileReader(file));
	}

	private FileUtils()
	{
		
	}

	public static FileUtils getInstance() throws FileNotFoundException {
		
		if(singleton == null){
			singleton = new FileUtils();
		}		
		
		return singleton;
	}	
	
	public String getFirstLine(File file) throws IOException 
	{		
		return getBufferedReaderForFile(file).readLine();
	}


    public boolean deleteFile(File file) {
        return file.delete();
    }
}
