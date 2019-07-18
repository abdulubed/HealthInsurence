package com.usa.state.gov.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_MASTER")
public class PlanMasterEntity {
	
	@Id
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_DESCRIPTION")
	private String planDescription;
	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;
	

}
