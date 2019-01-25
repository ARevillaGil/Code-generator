package arevilla.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Implementation of the WebMvcConfigurer.
 * @author Alberto Revilla
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/**
	 * Update the ViewControllerRegistry with the application pages.
	 */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/new").setViewName("new");
        registry.addViewController("/userCreated").setViewName("userCreated");
        registry.addViewController("/generateCode").setViewName("generateCode");
        registry.addViewController("/showCodes").setViewName("showCodes");
        registry.addViewController("/codeCreated").setViewName("codeCreated");
        registry.addViewController("/useCodes").setViewName("useCodes");
    }

}
