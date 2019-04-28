package by.bsu.taxipark.exception;

public class WrongDataException extends Exception {
    public WrongDataException() {
    }

    public WrongDataException(String message) {
        super(message);
    }

    public WrongDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDataException(Throwable cause) {
        super(cause);
    }

    public WrongDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
