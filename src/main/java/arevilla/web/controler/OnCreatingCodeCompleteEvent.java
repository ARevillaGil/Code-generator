package arevilla.web.controler;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import arevilla.model.AppUser;
import arevilla.model.Code;
/**
 * Implements the ApplicationEvent when the codes are created.
 * @author Alberto Revilla
 *
 */
@SuppressWarnings("serial")
public class OnCreatingCodeCompleteEvent extends ApplicationEvent {
	/**
	 * The application URL.
	 */
    private final String appUrl;
    /**
     * The Locale.
     */
    private final Locale locale;
    /**
     * The application user.
     */
    private final AppUser user;
    /**
     * The code created.
     */
    private final Code code;

    /**
     * Constructor of the application event.
     * @param user
     * @param code
     * @param locale
     * @param appUrl
     */
    public OnCreatingCodeCompleteEvent(final AppUser user, final Code code, final Locale locale, final String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
        this.code = code;
    }

    //

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public AppUser getUser() {
        return user;
    }

	public Code getCode() {
		return code;
	}

}
