package arevilla.web.controler;

import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import arevilla.model.AppUser;
import arevilla.model.Code;
import arevilla.service.ICodeService;
import arevilla.service.IUserService;
/**
 * Controller for the code pages.
 * @author Alberto Revilla
 *
 */
@Controller
public class CodeController {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    /**
     * Event publisher.
     */
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    /**
     * Interface for the code service.
     */
    @Autowired
    private ICodeService codeService;
    /**
     * Interface for the user service.
     */
    @Autowired
    private IUserService userService;
	/**
	 * Create a new code for the user.
	 * @param user the user´s code
	 * @param request
	 * @return redirect to codeCreated.html
	 */
	@RequestMapping(value = "/generateCode", method = RequestMethod.POST)
    public String createCodeForUser(@Valid final AppUser user, final HttpServletRequest request) {
        LOGGER.debug("Creating new code for the user: {}", user);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = userService.getUser(auth.getName());
        
        String code;
        boolean uniqueCode = true;
        do {
	        code = createNewCode();
	        uniqueCode = codeService.findCode(code);
        }while(uniqueCode);
        Code newCode = new Code();
        newCode.setCode(code);
        newCode.setAppUser(appUser);
        final Code savedCode = codeService.saveCode(newCode);
        eventPublisher.publishEvent(new OnCreatingCodeCompleteEvent(appUser, savedCode, request.getLocale(), getAppUrl(request)));
        return "codeCreated";
    }
	
	/**
	 * Show all the user codes.
	 * @param user the user who apply for his codes
	 * @param model 
	 * @param request
	 * @return redirect to showCodes.html
	 */
	@RequestMapping(value = "/showCodes", method = RequestMethod.POST)
    public String  showCodesForUser(@Valid final AppUser user, Model model, final HttpServletRequest request) {
        LOGGER.debug("Showing the codes for the user: {}", user);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = userService.getUser(auth.getName());
        
        model.addAttribute("codes", codeService.findByUser(appUser));
        
        eventPublisher.publishEvent(new OnShowingCodesCompleteEvent(appUser, request.getLocale(), getAppUrl(request)));
        return "showCodes";
    }
	/**
	 * Take the selected code and set it as used.
	 * @param user the user who use the code
	 * @param codeId identification of the code
	 * @param model
	 * @param request
	 * @return redirect to useCodes.html
	 */
	@RequestMapping(value = "/useCodes", method = RequestMethod.POST)
    public String  useCodes(@Valid final AppUser user, @RequestParam("codeId") long codeId, Model model, final HttpServletRequest request) {
        LOGGER.debug("Showing the codes for the user: {}", user);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = userService.getUser(auth.getName());
        
        Set<Code> codes = codeService.findByUser(appUser);
        Code savedCode = new Code();
        for(Code c : codes)
        	if(c.getCodeId() == codeId) {
        		c.setUsed(true);
        		codeService.saveCode(c);
        		savedCode = c;
        	}
        
        model.addAttribute("codes", codeService.findByUser(appUser));
        
        eventPublisher.publishEvent(new OnCreatingCodeCompleteEvent(appUser, savedCode, request.getLocale(), getAppUrl(request)));
        return "useCodes";
    }
	
	/**
	 * Create the application URL.
	 * @param request The servlet request
	 * @return The complete URL path.
	 */
	private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
	
	/**
	 * Create a new random alphanumeric code.
	 * @return String with the code.
	 */
	private String createNewCode() {
		return UUID.randomUUID().toString();
	}

}
