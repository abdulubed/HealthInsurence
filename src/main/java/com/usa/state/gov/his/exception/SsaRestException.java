package com.usa.state.gov.his.exception;

public class SsaRestException extends RuntimeException{
	

		private static final long serialVersionUID = 1L;

		public SsaRestException(String exceptionMsg)
		{
			super(exceptionMsg);
		}

}
