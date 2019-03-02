package by.bsu.matrices.exceptions;

/**This file contains exceptions used in this application
 *
 */
public class MatrixException extends Exception {
    public MatrixException() {}

    public MatrixException(String message) {
        super(message);
    }

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixException(Throwable cause) {
        super(cause);
    }
}
