package com.usa.state.gov.his.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usa.state.gov.his.entity.AdminMasterEntity;
import com.usa.state.gov.his.model.AdminModel;
import com.usa.state.gov.his.model.PlanModel;
import com.usa.state.gov.his.model.RoleModel;

@Service
public interface HisService {
	
	public void insertUserData(AdminModel model) throws Exception;
	
	public List<RoleModel> getRolesList();
	
	public List<AdminModel> getAllAccounts();
	
	public String validateEmail(String email);
	
	public void insertPlanData(PlanModel model);
	
	public  List<PlanModel> getAllPlans();
	
	public void statusInActive(Long serialNumber);
	
	public void statusActive(Long serialNumber);
	
	public AdminModel editAccountDetails(Long serialNumber) throws Exception;
	
	
	//public byte[] getImageById(Long ssnNumber);
		

}
