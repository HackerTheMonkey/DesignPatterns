package com.example.designpatterns.memento;

public class DataWritingResponse {

    private final boolean value;
    private final int lastProcesedRecord;

    public DataWritingResponse(boolean value, int lastProcesedRecord) {
        this.value = value;
        this.lastProcesedRecord = lastProcesedRecord;
    }


    public int getLastProcesedRecord() {
        return lastProcesedRecord;
    }

    public boolean getProcessingResult() {
        return value;
    }

}
