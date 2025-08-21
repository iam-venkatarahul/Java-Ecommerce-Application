/*
*Updated Global Exception Handler for E-commerce Project
*This code handles various exceptions that may occur in the application, such as validation errors, resource
*/
package com.ecommerce.project.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.project.payload.ApiResponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionsHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String , String>>myMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String , String> response = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(
				err -> {
					String fieldName = ((FieldError)err).getField();
					String message = err.getDefaultMessage();
					response.put(fieldName, message);
				} );
		return new ResponseEntity<Map<String, String>>(response , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>myResourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(message , false);
		return new ResponseEntity<>(apiresponse , HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponse>ApiException(ApiException ex){
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(message , false);
		return new ResponseEntity<>(apiresponse , HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(NoCategoryPresentException.class)
	public ResponseEntity<ApiResponse>NoCategoryPresentException(NoCategoryPresentException ex){
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(message , false);
		return new ResponseEntity<>(apiresponse , HttpStatus.BAD_REQUEST);	
	}
}










