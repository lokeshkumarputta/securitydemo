package com.elife.security.securitydemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomConfiguration extends WebSecurityConfigurerAdapter{

	// Authentication : User --> Roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("lputta").password("password").roles("USER").and()
										.withUser("sreeadmin").password("password").roles("USER","ADMIN");
		
					
	}
	
	// Authorization : Role -> Access
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic().and().authorizeRequests().antMatchers("/security/**").hasRole("USER")
													.antMatchers("*/**").hasRole("ADMIN").and()
														.csrf().disable().headers().frameOptions().disable();
	}
	
}
