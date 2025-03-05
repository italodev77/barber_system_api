package dev.mivas.BarberSystem.exception;

public class UsernameOrPasswordInvalidException extends RuntimeException{

    public UsernameOrPasswordInvalidException(String message){
        super(message);
    }
}
