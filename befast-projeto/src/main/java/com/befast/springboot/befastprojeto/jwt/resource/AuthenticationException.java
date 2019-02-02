package com.befast.springboot.befastprojeto.jwt.resource;

public class AuthenticationException extends RuntimeException {
	private static final long serialVersionUID = -393366758854955973L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}