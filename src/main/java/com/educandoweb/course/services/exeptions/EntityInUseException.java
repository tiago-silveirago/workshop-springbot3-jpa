package com.educandoweb.course.services.exeptions;

public class EntityInUseException extends RuntimeException {

    public EntityInUseException(String message) {
      super(message);
    }
}
