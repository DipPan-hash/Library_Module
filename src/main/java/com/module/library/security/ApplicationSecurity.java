package com.module.library.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.module.library.constants.Roles;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/books/admin/**").hasRole(Roles.ADMIN.name())
				.antMatchers("/books/users/**").hasRole(Roles.USER.name()).anyRequest().authenticated().and()
				.formLogin().and().httpBasic().and().csrf().disable();
	}
}
