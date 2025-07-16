package com.educandoweb.course.services.exeptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
      super(message);
    }
}
