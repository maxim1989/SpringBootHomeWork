package pro.sky.mlfedorov.sandbox.exceptions;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String message) {
        super(message);
    }
}