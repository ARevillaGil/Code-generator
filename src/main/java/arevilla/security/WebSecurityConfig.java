package arevilla.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import arevilla.service.UserDetailsServiceImpl;

/**
 * Security config class.
 * @author Alberto Revilla
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Configure the access permissions for the user before and after the login.
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/new", "/createUser").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
    	/**
	   * Bean to access the user details.
	   */
	  @Bean
	  public UserDetailsService userDetailsService() {
	    return new UserDetailsServiceImpl();
	  };
	  /**
	   * Bean used to encode the user password.
	   * @return the encoder
	   */
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  };
	  /**
	   * Use the password encoder to send the password to the user details implementation.
	   */
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	  }
	 
}