package com.sujith.employeemanager.exception;

public class UserNotfoundException extends RuntimeException
{
    public UserNotfoundException(String message)
    {
        super(message);
    }
}
