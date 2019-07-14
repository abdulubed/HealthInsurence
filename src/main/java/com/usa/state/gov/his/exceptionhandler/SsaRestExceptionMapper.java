package com.usa.state.gov.his.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.usa.state.gov.his.exception.RestApiError;
import com.usa.state.gov.his.exception.SsaRestException;

@RestController
@ControllerAdvice
public class SsaRestExceptionMapper {
	
	@ExceptionHandler(value = SsaRestException.class)
	public ResponseEntity<RestApiError> handleSsaResException() {
		
		RestApiError restApiError = new RestApiError(404, "Citizen SsnNumber not found with SsnNumber", new Date());
		
		return new ResponseEntity<RestApiError> (restApiError, HttpStatus.BAD_REQUEST);
	}
	
	
	
	

}
