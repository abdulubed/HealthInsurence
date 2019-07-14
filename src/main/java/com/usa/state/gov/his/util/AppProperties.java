package com.usa.state.gov.his.util;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "his")
@Data
public class AppProperties {
	
	private String enrollSuccess;
	private String enrollFailure;
	private String message;
	private String userRegistration;

}
