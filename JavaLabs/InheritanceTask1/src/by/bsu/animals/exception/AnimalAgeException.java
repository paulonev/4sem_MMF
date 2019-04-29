package by.bsu.animals.exception;

public class AnimalAgeException extends Exception {
    public AnimalAgeException() {
    }

    public AnimalAgeException(String message) {
        super(message);
    }

    public AnimalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnimalAgeException(Throwable cause) {
        super(cause);
    }

    public AnimalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
