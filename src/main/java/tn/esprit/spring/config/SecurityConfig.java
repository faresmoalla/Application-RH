/*package tn.esprit.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER");

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		AuthenticationEntryPoint entryPoint = new CustomAuthenticationEntryPoint();
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(entryPoint);
	}

}
*/