package arevilla.web.error;
/**
 * Exception when the user is not found.
 * @author Alberto Revilla
 *
 */
public final class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    /**
     * Constructor without fields.
     */
    public UserNotFoundException() {
        super();
    }

    /**
     * Constructor with the exception message and the cause.
     * @param message
     * @param cause
     */
    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with the exception message.
     * @param message
     */
    public UserNotFoundException(final String message) {
        super(message);
    }

    /**
     * Cosntructor with the exception cause.
     * @param cause
     */
    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }

}
