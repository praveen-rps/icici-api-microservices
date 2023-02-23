package com.microservices.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class BankConfiguration extends WebSecurityConfigurerAdapter {
	/*
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/balance").hasRole("user")
		.antMatchers("/delete").hasRole("admin")
		.antMatchers("/details").authenticated()
		.antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();
	}
	*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("krishna").password("98765").authorities("user")
		.and()
		.withUser("anil").password("12345").authorities("admin")
		.and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());

	}
	
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.
	                httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers("/balance").hasRole("user")
	                .antMatchers("/delete").hasRole("admin")
	                .antMatchers("/details").hasAnyRole("admin","user")
	                .antMatchers("/contact").permitAll()
	                .and()
	                .formLogin().permitAll()
	                .and()
	                .logout().permitAll();
	    }


}
