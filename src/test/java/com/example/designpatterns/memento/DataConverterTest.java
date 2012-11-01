package com.example.designpatterns.memento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DataConverterTest 
{
    private DataConverter dataConverterWithoutValidation;
    private DataConverter dataConverterWithValidation;
    private DataConverter dataConverterWithMemento;


    @Before
    public void setup()
    {
        dataConverterWithoutValidation = new DataConverter();
        dataConverterWithValidation = new DataConverter("/Users/khafaji/tmp/raw_data_with_invalid_records.txt");
        dataConverterWithMemento = new DataConverter("/Users/khafaji/tmp/raw_data_with_invalid_records_for_memento.txt");
    }

	@Test
	public void canSuccessfullyConvertRawDataIntoSqlInserts() throws IOException
	{		
		dataProcessingShouldCompleteSuccessfully();	
		
		shouldGenerateNonEmptyOutputFile();
		
		mustConvertAllData();
		
	}

    @After
    public void cleanup() throws FileNotFoundException {
        FileUtils.getInstance().deleteFile(new File("/Users/khafaji/tmp/sql_inserts.txt"));
    }


    @Test
	public void stopProcessingWhenFacingValidationError() throws IOException
	{
		dataProcessingShouldFail();
		
		outputFileShouldContainOnlySuccessfullyProcessedRecords();
	}

    @Test
    public void resumeProcessingFromTheLastProcessedRecord() throws IOException {

        processingShouldFailWhenHavingInvalidRecords();

        fixValidationErrors();

        resumeProcessingShouldBeSuccessful();

        processingShouldResumeFromLastProcessedRecord();
    }

    private void processingShouldResumeFromLastProcessedRecord() throws IOException {
        assertThat("The SQL output file should contain all the processed input records without duplication", FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/sql_inserts.txt")), is(equalTo(FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/raw_data_with_invalid_records_for_memento_corrected.txt")))));
        assertThat("The SQL output file should contain all the processed input records without duplication", FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/sql_inserts.txt")), is(equalTo(FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/raw_data_with_invalid_records_for_memento.txt")))));
    }

    private void resumeProcessingShouldBeSuccessful() throws IOException {
        assertThat("Data processing should be successful after correcting the validation errors", dataConverterWithMemento.process(), is(true));
    }

    private void fixValidationErrors() {
        /**
         * Obtain the memento object that represent the current state of
         * the DataConverter
         *
         * Design tip: The Memento class doesn't expose any instance members,
         * its internal state is completely hidden and it only makes sense to
         * its outer class as it can access its private members.
         */
        DataConverter.Memento memento = dataConverterWithMemento.getMemento();


        /**
         * Emulate correcting the raw input data file
         */
        dataConverterWithMemento.setInputFile("/Users/khafaji/tmp/raw_data_with_invalid_records_for_memento_corrected.txt");

        /**
         * Set the DataConverter to its previous state using the previously retrieved memento
         */
        dataConverterWithMemento.setMemento(memento);
    }

    private void processingShouldFailWhenHavingInvalidRecords() throws IOException {
        assertThat("The data processing should fail when there are invalid records", dataConverterWithMemento.process(), is(false));
    }


    private void outputFileShouldContainOnlySuccessfullyProcessedRecords()
			throws IOException, FileNotFoundException {
        int fileRecordsCount = FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/sql_inserts.txt"));
        int lastProcessedId = dataConverterWithValidation.getLastProcessedId();

        assertThat("SQL file must contain only successfully processed records", fileRecordsCount, is(equalTo(lastProcessedId)));
	}

	private void dataProcessingShouldFail() throws IOException {
        assertThat("The data conversion process must fail when there are validation errors", dataConverterWithValidation.process(), is(equalTo(false)));
	}

	private void mustConvertAllData() throws IOException, FileNotFoundException {
		int outputFileRecordsCount = FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/sql_inserts.txt"));
		int inputFileRecordsCount = FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/raw_data.txt"));
        String firstLine = FileUtils.getInstance().getFirstLine(new File("/Users/khafaji/tmp/sql_inserts.txt"));

        assertThat("The DataConverter should convert all the data in the raw data file", outputFileRecordsCount, is(equalTo(inputFileRecordsCount)));
        assertThat("The SQL insert must correctly represent the customer data", "insert into CUSTOMER_TABLE values ('hasnein','khafaji','23874568374');", is(equalTo(firstLine)));
	}

	private void shouldGenerateNonEmptyOutputFile() throws IOException,
			FileNotFoundException {
        assertThat("The SQL inserts file must not be empty", FileUtils.getInstance().getFileRecordsCount(new File("/Users/khafaji/tmp/sql_inserts.txt")), greaterThan(0));
	}

	private void dataProcessingShouldCompleteSuccessfully() throws IOException {
        assertThat("The data conversion process must succeed", dataConverterWithoutValidation.process(), is(true));
	}
}
