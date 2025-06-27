package com.ecommerce.project.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoCategoryPresentException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NoCategoryPresentException(String message) {
		super(message);
	}
	
	
	
	

}
