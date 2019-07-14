package com.usa.state.gov.his.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="ROLES_MASTER")
public class RolesMasterEntity {
	
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "roles")
	private String roles;
	

}
