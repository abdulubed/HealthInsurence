package com.usa.state.gov.his.model;

import java.util.Date;

import lombok.Data;

@Data
public class PlanModel {
	
	private String planName;
	private String planDescription;
	private Date startDate;
	private Date endDate;
	

}
