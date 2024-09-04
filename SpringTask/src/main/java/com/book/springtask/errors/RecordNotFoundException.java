package com.book.springtask.errors;

public class  RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException() {
        super();

    }

    public RecordNotFoundException(String message) {
        super(message);
    }

}
