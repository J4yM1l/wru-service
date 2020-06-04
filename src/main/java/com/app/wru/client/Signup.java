package com.app.wru.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.wru.models.Customer;
import com.app.wru.serviceImplementation.SignUpServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/wru/api")
public class Signup {
	@Autowired
	SignUpServiceImpl signUpService;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ResponseEntity<?> signUp(@RequestBody Customer signupDetails) throws Exception{
//		System.out.println("Signing Up!");
//		System.out.println(signupDetails.toString());
		signUpService.addUser(signupDetails);
		return ResponseEntity.status(HttpStatus.CREATED).
				header("Account ", String.valueOf(HttpStatus.CREATED)+ " Successfully")
				.body("Complete");
		
	}
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public String testSignup() {
		System.out.println("Calling testSignup");
		return "testSignup";
	}

}
