package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.security.database.DatabaseLoginSuccessHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService ; 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable() ; 
		
		http.authorizeRequests()
			.antMatchers("/**").access("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_ADMIN') ")
			.and()
			.formLogin()
				.loginPage("/login/login")
				.permitAll()
				.loginProcessingUrl("/login/processlogin") 
				.defaultSuccessUrl("/home/index") 
				.failureUrl("/login/login?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.successHandler(databaseLoginSuccessHandler)
				
			.and()
			.logout().logoutUrl("/login/logout")
			.logoutSuccessUrl("/login/login?logout")
			;
	}	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService);
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private DatabaseLoginSuccessHandler databaseLoginSuccessHandler ; 

}
