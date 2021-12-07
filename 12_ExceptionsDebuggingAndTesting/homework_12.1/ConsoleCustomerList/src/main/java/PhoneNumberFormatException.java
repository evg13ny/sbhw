public class PhoneNumberFormatException extends RuntimeException {
    public PhoneNumberFormatException() {
    }

    public PhoneNumberFormatException(String message) {
        super(message);
    }

    public PhoneNumberFormatException(Throwable cause) {
        super(cause);
    }

    public PhoneNumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
