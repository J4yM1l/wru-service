package com.app.wru.jwtFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.wru.serviceImplementation.TheUserDetailsService;
import com.app.wru.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private TheUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");
		System.out.println("Request Header: " + authorizationHeader);
		String username = null;
		String jwt = null;		
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
			System.out.println("JWT: " + jwt);
			System.out.println("Username: " + username);
			
		}			

			System.out.println("Security Context: " + SecurityContextHolder.getContext().getAuthentication());

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
				System.out.println("UserDetails: " + userDetails);
				if (jwtUtil.validateToken(jwt, userDetails)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					System.out.println("UserNamePass: " + usernamePasswordAuthenticationToken);
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}							
				
			}
			
			chain.doFilter(request, response);
			
			
		} 

}
