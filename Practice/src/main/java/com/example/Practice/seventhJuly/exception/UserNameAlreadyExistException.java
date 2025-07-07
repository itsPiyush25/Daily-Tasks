package com.example.Practice.seventhJuly.exception;

public class UserNameAlreadyExistException extends RuntimeException {
    public UserNameAlreadyExistException(String s) {
        super(s);
    }
}
