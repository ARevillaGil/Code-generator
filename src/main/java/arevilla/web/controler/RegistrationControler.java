package arevilla.web.controler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import arevilla.model.AppUser;
import arevilla.service.IUserService;
/**
 * Controller for create new users.
 * @author Alberto Revilla
 *
 */
@Controller
public class RegistrationControler {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	/**
	 * The user service.
	 */
    @Autowired
    private IUserService userService; 
    /**
     * The event publisher.
     */
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    

    /**
     * Create a new application user in the database.
     * @param newUser the user to be saved
     * @param request
     * @return redirect to userCreated.html
     */
  @RequestMapping(value = "/createUser", method = RequestMethod.POST) 
  public String registerUserAccount(AppUser newUser, HttpServletRequest request) { 
	  
	  LOGGER.debug("Registering user account with information: {}", newUser);
	  
	  final AppUser registered = userService.registerNewUserAccount(newUser);
	  
	  eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered,
	  request.getLocale(), getAppUrl(request))); 
	  return "userCreated"; 
  }
	 
   /**
    * The application URL.
    * @param request
    * @return the application URL
    */
	private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }


}
