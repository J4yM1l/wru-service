package com.app.wru.authentication;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID1 = 1L;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5493587576306222991L;
	private final String jwt;

	    public AuthenticationResponse(String jwt) {
	        this.jwt = jwt;
	    }

	    public String getJwt() {
	        return jwt;
	    }

}
