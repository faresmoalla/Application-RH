package tn.esprit.spring.config;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	public CustomAuthenticationEntryPoint() {
		this.setRealmName("myown");
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.setHeader("WWW-Authenticate", "myown");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
	}
}