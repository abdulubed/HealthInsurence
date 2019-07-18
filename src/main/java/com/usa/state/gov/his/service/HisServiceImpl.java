package com.usa.state.gov.his.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.state.gov.his.entity.AdminMasterEntity;
import com.usa.state.gov.his.entity.PlanMasterEntity;
import com.usa.state.gov.his.entity.RolesMasterEntity;
import com.usa.state.gov.his.model.AdminModel;
import com.usa.state.gov.his.model.PlanModel;
import com.usa.state.gov.his.model.RoleModel;
import com.usa.state.gov.his.repository.AdminMasterRepository;
import com.usa.state.gov.his.repository.PlanMasterRepository;
import com.usa.state.gov.his.repository.RolesMasterRepository;
import com.usa.state.gov.his.util.EmailSending;
import com.usa.state.gov.his.util.PasswordEncrypt;

@Service
public class HisServiceImpl extends Exception implements HisService {

	@Autowired
	private AdminMasterRepository adminMasterRepository;

	@Autowired
	private RolesMasterRepository rolesMasterRepository;
	
	@Autowired
	private PlanMasterRepository planMasterRepository;
	
	@Autowired
	private PasswordEncrypt passwordEncrypt;
	
	@Autowired
	private EmailSending emailSending;
	
	@Override
	public void insertUserData(AdminModel model) throws Exception {
		String encryptedPassword = passwordEncrypt.doEncrypt(model.getPassword());
		model.setPassword(encryptedPassword);
		//System.out.println(model);
		
		AdminMasterEntity entity = new AdminMasterEntity();
		BeanUtils.copyProperties(model, entity);
		entity.setStatus("active");
		AdminMasterEntity res = adminMasterRepository.save(entity);
		//System.out.println(res.getSsnNumber() + "" + (res.getSsnNumber() > 0));
		//System.out.println(res.getSsnNumber());
		BeanUtils.copyProperties(res, model);
		//System.out.println("from serviceimpl"+res.getDateOfBirth());
		
		Long serialNumber = model.getSerialNumber();
		if(serialNumber > 0) {
			String decryptPassword = passwordEncrypt.doDecrypt(model.getPassword());
			model.setPassword(decryptPassword);
			emailSending.emailSending(model);
		}
		
		
		//String ssnNumberString = String.valueOf(model.getSsnNumber());
		//String ssnNumber = ssnNumberString.substring(0, 4)+"-"+ssnNumberString.substring(4,6)+"-"+ssnNumberString.substring(6, 9);
		//return ssnNumber;
	}

	@Override
	public List getRolesList() {
		List<RolesMasterEntity> rolesMasterEntity = rolesMasterRepository.findAll();
		List roleModelList = new ArrayList();
		for (RolesMasterEntity entity : rolesMasterEntity) {
			RoleModel rolesModel = new RoleModel();
			BeanUtils.copyProperties(entity, rolesModel);
			roleModelList.add(rolesModel.getRoles());
		}
		return roleModelList;
	}

	@Override
	public List<AdminModel> getAllAccounts() {
		List<AdminModel> adminModelList = new ArrayList();
		List<AdminMasterEntity> adminMasterEntityList = adminMasterRepository.findAll();
		for (AdminMasterEntity adminMasterOne : adminMasterEntityList) {
			AdminModel adminModelOne = new AdminModel();
			BeanUtils.copyProperties(adminMasterOne, adminModelOne);
			adminModelList.add(adminModelOne);
		}
		//System.out.println(adminMasterEntityList);
		return adminModelList;
	}

	@Override
	public String validateEmail(String email) {
		String emailId = null;
		int count=0;
		count = adminMasterRepository.findEmail(email);
		//System.out.println(count);
		if (count == 0) {
			return "success";
		}else {
			return "duplicate";
		}
	}

	@Override
	public void insertPlanData(PlanModel model) {
		PlanMasterEntity planMasterEntity = new PlanMasterEntity();
		BeanUtils.copyProperties(model, planMasterEntity);
		PlanMasterEntity planEntity = planMasterRepository.save(planMasterEntity);
		BeanUtils.copyProperties(planEntity, model);
	}
	


	@Override
	public List<PlanModel> getAllPlans() {
		List<PlanModel> planLists = new ArrayList<PlanModel>();
		List<PlanMasterEntity> planMasterEntitiyList = planMasterRepository.findAll();
		for(PlanMasterEntity plan: planMasterEntitiyList) {
			PlanModel planModel = new PlanModel();
			BeanUtils.copyProperties(plan, planModel);
			planLists.add(planModel);
		}
		return planLists;
	}

	@Override
	public void statusInActive(Long serialNumber) {		
		adminMasterRepository.statusInActiveQuery(serialNumber);
		//System.out.println(serialNumber);		
	}
	
	@Override
	public void statusActive(Long serialNumber) {		
		adminMasterRepository.statusActiveQuery(serialNumber);
		//System.out.println(serialNumber);		
	}

	@Override
	public AdminModel editAccountDetails(Long serialNumber) throws Exception {
		AdminMasterEntity allData = null;
		Optional<AdminMasterEntity> adminMaster = adminMasterRepository.findById(serialNumber);
		
		AdminModel adminModel = new AdminModel();
		if(adminMaster.isPresent()) {
			allData = adminMaster.get();
			String decryptPassword = passwordEncrypt.doDecrypt(allData.getPassword());
			allData.setPassword(decryptPassword);
			BeanUtils.copyProperties(allData, adminModel);
			//System.out.println("comming from edit " +adminModel);
		}
		return adminModel;
	}

	
}
