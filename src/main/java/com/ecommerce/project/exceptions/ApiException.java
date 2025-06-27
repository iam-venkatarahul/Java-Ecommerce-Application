package com.ecommerce.project.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiException extends RuntimeException {
	
	private static final long serialversionUID = 1L;
	
	public ApiException(String message) {
		super(message);
	}
	
	

}
