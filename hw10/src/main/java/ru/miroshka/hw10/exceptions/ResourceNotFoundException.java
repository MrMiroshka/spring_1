package ru.miroshka.hw10.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public  ResourceNotFoundException (String message){
        super(message);
    }
}
