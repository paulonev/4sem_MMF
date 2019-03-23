package by.bsu.trains.exceptions;

public class NotValidAmountOfSeatsException extends Exception {
    public NotValidAmountOfSeatsException() {}

    public NotValidAmountOfSeatsException(String message) {
        super(message);
    }

    public NotValidAmountOfSeatsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidAmountOfSeatsException(Throwable cause) {
        super(cause);
    }

    public NotValidAmountOfSeatsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
