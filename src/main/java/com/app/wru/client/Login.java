package com.app.wru.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.wru.authentication.AuthenticationRequest;
import com.app.wru.authentication.AuthenticationResponse;
import com.app.wru.serviceImplementation.TheUserDetailsService;
import com.app.wru.util.JwtUtil;

@CrossOrigin
@RestController
//@RequestMapping(path="/wru/api")
public class Login {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private TheUserDetailsService theUserDetailsService;
	
	private Authentication authentication;
	
	private UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
	
	@RequestMapping({"/hello"})
	public String hello() {
		System.out.println("Calling Hello world");
		return "Hello World";
	}

	
	@RequestMapping(value="/authenticate", method= RequestMethod.POST)
	private ResponseEntity<?> loggingIn(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		System.out.println("User Name: "+ authenticationRequest.getUsername());
		System.out.println("Password: "+ authenticationRequest.getPassword());		
	
	try {
		authentication = authenticationManager.authenticate(
				usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
		);
//		authentication.setAuthenticated(false);
		System.out.println("Authentication result: "+ authentication.isAuthenticated());
		System.out.println("UsernamePasswordAuthenticationToken result: "+ usernamePasswordAuthenticationToken.isAuthenticated());
	}
	catch (BadCredentialsException e) {
		throw new Exception("Incorrect username or password", e);
	}


	final UserDetails userDetails = theUserDetailsService
			.loadUserByUsername(authenticationRequest.getUsername());
	System.out.println(userDetails.getPassword());

	final String jwt = jwtTokenUtil.generateToken(userDetails);

	return ResponseEntity.ok(new AuthenticationResponse(jwt));
//	return ResponseEntity.status(HttpStatus.CREATED).
//			header("Account ", String.valueOf(HttpStatus.CREATED)+ " Successfully")
//			.body("Completed");
}
	

}
