package com.aus.post.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * AusPostSecurity enables security features
 * 
 * @author Shruti Mahapatra
 *
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class AusPostSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeRequests()
			.antMatchers("/get/**").permitAll()
			.antMatchers("/get/*/{\\d}").permitAll()
			.anyRequest().fullyAuthenticated();
		
		httpSecurity.httpBasic().and().authorizeRequests()
		.antMatchers("/addNewAddress").hasRole("ADMIN")
		.and().csrf().disable();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("auspostadmin").password("auspostadmin1").roles("ADMIN");
	}
	
}
