package com.usa.state.gov.his.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.state.gov.his.model.AdminModel;
import com.usa.state.gov.his.service.HisServiceImpl;
import com.usa.state.gov.his.util.AppProperties;

/**
 * @author Abdul
 *
 */
@Controller
public class HisController {

	@Autowired
	private HisServiceImpl adminServiceImpl;

	@Autowired
	private AppProperties appProperties;

	/**
	 * this method is for display ssn enrollment form
	 * 
	 * @param model
	 * @return userRegistraion jsp page
	 */
	@RequestMapping(path = "/displayForm", method = RequestMethod.GET)
	public String displayForm(Model model) {
		model.addAttribute("adminModel", new AdminModel());
		initializerValues(model);
		return appProperties.getUserRegistration();
	}

	/**
	 * this method is for form registration
	 * 
	 * @param model
	 * @param ssnMasterEntiry
	 * @param adminModel
	 * @return userRegistration jsp page
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/insertUserData")
	public String insertUserData(RedirectAttributes redirectAttributes,
			@ModelAttribute("adminModel") @Valid AdminModel adminModel, BindingResult result) {


		if (result.hasErrors()) {
			return "redirect:/displayForm";
		}
		redirectAttributes.addFlashAttribute(appProperties.getMessage(), appProperties.getEnrollSuccess());
		initializerValues(redirectAttributes);
		adminServiceImpl.insertUserData(adminModel);
		return "redirect:/displayForm";
	}

	public String initializerValues(Model model) {

		List list = adminServiceImpl.getRolesList();
		model.addAttribute("rolesList", list);
		List gendersList = new ArrayList();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("gendersList", gendersList);
		return appProperties.getUserRegistration();

	}

	@RequestMapping("/getAllAccounts")
	public String getallSsnRecords(Model model) {

		List<AdminModel> accountRecords = adminServiceImpl.getAllAccounts();

		model.addAttribute("accountRecords", accountRecords);

		return "getAllAccounts";

	}

	@GetMapping(value = "/email")
	public @ResponseBody String emailValidation(HttpServletRequest req,Model model ) throws Exception {
		String email=null;
		String msg=null;
		email = req.getParameter(email);
		System.out.println(email);
		 msg = adminServiceImpl.validateEmail(email);		
		 System.out.println(msg);
		return msg;
	}
}
