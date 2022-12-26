package tn.esprit.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import tn.esprit.spring.service.MyUserDetailsService;
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
@Autowired
private MyUserDetailsService userDetailsService;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);}
@Override
protected void configure(HttpSecurity http) throws Exception {
	/*
	http.httpBasic().disable();
	


http.authorizeRequests() .antMatchers("/registration","/login").permitAll()

//.antMatchers("/Assurance/get-assurance").access("hasRole('SUPERADMIN')")
//.antMatchers("/get**}").access("hasRole('Client')")
//.antMatchers("/retrieve-all-clients").access("hasRole('ADMIN')")
.anyRequest()
.authenticated()
.and()
.httpBasic().and().csrf().disable();
*/

		AuthenticationEntryPoint entryPoint = new CustomAuthenticationEntryPoint();
		http.authorizeRequests() .antMatchers("/registration","/login").permitAll()

		//.antMatchers("/Assurance/get-assurance").access("hasRole('SUPERADMIN')")
		//.antMatchers("/get**}").access("hasRole('Client')")
		//.antMatchers("/retrieve-all-clients").access("hasRole('ADMIN')")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic().authenticationEntryPoint(entryPoint).and().csrf().disable();
		




}}

