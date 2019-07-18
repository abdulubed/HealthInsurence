package com.usa.state.gov.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Data;

@Entity
@Data
@Table(name = "ADMIN_MASTER")
public class AdminMasterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SERIAL_NUMBER")
	private Long serialNumber;
	
	@Column(name = "STATUS")
	private String status;
	
	

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@Column(name = "SSN_NUMBER")
	@NumberFormat(style = Style.NUMBER)
	private Long SsnNumber;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "ROLE")
	private String role;

}
