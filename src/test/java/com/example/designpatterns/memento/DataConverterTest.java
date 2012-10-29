package com.example.designpatterns.memento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class DataConverterTest 
{
	private DataConverter dataConverter;	
	
	@Before
	public void setup()
	{
		dataConverter = new DataConverter();
	}
	
	@Test
	public void canSuccessfullyConvertRawDataIntoSqlInserts() throws IOException
	{		
		dataProcessingShouldCompleteSuccessfully();	
		
		shouldGenerateNonEmptyOutputFile();
		
		mustConvertAllData();
		
	}

	private void mustConvertAllData() throws IOException, FileNotFoundException {
		int outputFileRecordsCount = FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/sql_inserts.txt"));
		int inputFileRecordsCount = FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/raw_data.txt"));
		assertTrue("The DataConverter should convert all the data in the raw data file",  outputFileRecordsCount == inputFileRecordsCount);
		assertTrue("The SQL insert must correctly represent the customer data", "insert into CUSTOMER_TABLE values ('hasnein','khafaji','23874568374');".equals(FileUtils.getInstance().getFirstLine(new File("/Users/khafaji/tmp/sql_inserts.txt"))));
	}

	private void shouldGenerateNonEmptyOutputFile() throws IOException,
			FileNotFoundException {
		assertTrue("The SQL inserts file must not be empty", FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/sql_inserts.txt")) > 0);
	}

	private void dataProcessingShouldCompleteSuccessfully() throws IOException {
		assertTrue("The data conversion process must succeed", dataConverter.process());
	}
}
