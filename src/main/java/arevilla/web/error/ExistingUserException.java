package arevilla.web.error;

/**
 * Exception when the user already exists.
 * @author Alberto Revilla
 *
 */
public class ExistingUserException extends RuntimeException{
    private static final long serialVersionUID = 5861310537366287163L;

    /**
     * Cosntructor without fields.
     */
    public ExistingUserException() {
        super();
    }

    /**
     * Constructor with the exception message and cause.
     * @param message
     * @param cause
     */
    public ExistingUserException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * Constructor with the exception message.
     * @param message
     */
    public ExistingUserException(final String message) {
        super(message);
    }
    /**
     * Constructor with the exception cause.
     * @param cause
     */
    public ExistingUserException(final Throwable cause) {
        super(cause);
    }

}
