package by.bsu.phonesUtilizer.exceptions;

public class InvalidHardwareParametersException extends Exception {

    public InvalidHardwareParametersException() {
    }

    public InvalidHardwareParametersException(String message) {
        super(message);
    }

    public InvalidHardwareParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidHardwareParametersException(Throwable cause) {
        super(cause);
    }

    public InvalidHardwareParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
