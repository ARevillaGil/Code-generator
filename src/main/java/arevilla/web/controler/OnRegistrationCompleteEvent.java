package arevilla.web.controler;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import arevilla.model.AppUser;
/**
 * Implements the ApplicationEvent when the user is registrated.
 * @author Alberto Revilla
 *
 */
@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {
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
     * Constructor of the application event.
     * @param user
     * @param locale
     * @param appUrl
     */
    public OnRegistrationCompleteEvent(final AppUser user, final Locale locale, final String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
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

}
