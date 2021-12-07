public class EmailFormatException extends RuntimeException {
    public EmailFormatException() {
    }

    public EmailFormatException(String message) {
        super(message);
    }

    public EmailFormatException(Throwable cause) {
        super(cause);
    }

    public EmailFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
