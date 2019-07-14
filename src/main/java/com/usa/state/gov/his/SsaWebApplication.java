package com.usa.state.gov.his;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsaWebApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SsaWebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SsaWebApplication.class, args);
	}

}
