package com.usa.state.gov.his.exception;

import java.util.Date;

import lombok.Data;

@Data
public class RestApiError {
	
	private Integer errorCode;
	private String errorDesc;
	private Date date;
	
	public RestApiError(Integer errorCode, String errorDesc, Date date) {
		super();
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
		this.date = date;
	}
	
	
	
	

}
