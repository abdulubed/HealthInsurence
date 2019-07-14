package com.usa.state.gov.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usa.state.gov.his.service.HisServiceImpl;

@RestController
@RequestMapping("/restValidation")
public class SsnRestController {

	@Autowired
	private HisServiceImpl ssaServiceImpl;

	/*@GetMapping(value = "/state")
	public String getStatesById(@RequestHeader("ssnNumber") Long ssnNumber) {
		String stateName = ssaServiceImpl.getStateNameById(ssnNumber);
		System.out.println(stateName);
		// return Response.status(200).entity(stateName).build();
		return stateName;
	}*/
}
