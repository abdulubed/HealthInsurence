package com.usa.state.gov.his.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.state.gov.his.entity.AdminMasterEntity;
import com.usa.state.gov.his.entity.RolesMasterEntity;
import com.usa.state.gov.his.exception.SsaRestException;
import com.usa.state.gov.his.model.AdminModel;
import com.usa.state.gov.his.model.RoleModel;
import com.usa.state.gov.his.repository.AdminMasterRepository;
import com.usa.state.gov.his.repository.RolesMasterRepository;

@Service
public class HisServiceImpl extends Exception implements HisService {

	@Autowired
	private AdminMasterRepository adminMasterRepository;

	@Autowired
	private RolesMasterRepository rolesMasterRepository;

	@Override
	public void insertUserData(AdminModel model) {
		AdminMasterEntity entity = new AdminMasterEntity();
		BeanUtils.copyProperties(model, entity);
		AdminMasterEntity res = adminMasterRepository.save(entity);
		//System.out.println(res.getSsnNumber() + "" + (res.getSsnNumber() > 0));
		//System.out.println(res.getSsnNumber());
		BeanUtils.copyProperties(res, model);
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
		System.out.println(adminMasterEntityList);
		return adminModelList;
	}

	@Override
	public String validateEmail(String email) {
		String emailId = null;
		Optional<AdminMasterEntity> adminMasterEntity = adminMasterRepository.findById(email);
		if (adminMasterEntity.isPresent()) {
			AdminMasterEntity emailValid = adminMasterEntity.get();
			emailId = emailValid.getEmail();
			System.out.println(emailId);
			return "success";
		} else {
			System.out.println(emailId);
			return "DuplicateMail";
		}
	}

	/*@Override
	public String getStateNameById(Long ssnNumber) {
		String state = null;
		Optional<AdminMasterEntity> ssnMasterEntity = adminMasterRepository.findById(ssnNumber);
		if (ssnMasterEntity.isPresent()) {
			AdminMasterEntity ssnValid = ssnMasterEntity.get();
			state = ssnValid.getState();
			System.out.println(state);
		} else {
			throw new SsaRestException("Citizen SsnNumber not found with SsnNumber" + ssnNumber);
		}
		return state;
	}*/

	/*@Override
	public List<SsnModel> getImages() {
		List<SsnMasterEntity> dataList = ssnMasterRepository.findAll();
		
		List imagesList = new ArrayList(dataList.size());
		for(SsnMasterEntity images : dataList) {
			SsnModel ssnModel = new SsnModel();
			BeanUtils.copyProperties(images, ssnModel);
			imagesList.add(images.getPhoto());
			
		}
		return imagesList;
	}*/
	
	/*public byte[] getImageById(Long ssnNumber) {
		byte[] image;
		Optional<AdminMasterEntity> ssnMasterEntity = adminMasterRepository.findById(ssnNumber);
		
			if (ssnMasterEntity.isPresent()) {
				AdminMasterEntity ssnValid = ssnMasterEntity.get();
				 image= ssnValid.getPhoto();
					} else {
				throw new SsaRestException("Photo not found" + ssnNumber);
			}
			return image;
	}*/

}
