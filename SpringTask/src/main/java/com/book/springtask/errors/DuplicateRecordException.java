package com.book.springtask.errors;

public class DuplicateRecordException extends RuntimeException{
public DuplicateRecordException(){
    super();
}
public DuplicateRecordException(String msg){
    super(msg);
}
}
