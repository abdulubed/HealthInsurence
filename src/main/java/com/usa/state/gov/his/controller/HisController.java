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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.state.gov.his.model.AdminModel;
import com.usa.state.gov.his.model.PlanModel;
import com.usa.state.gov.his.service.HisServiceImpl;
import com.usa.state.gov.his.util.AppProperties;

/**
 * @author Abdul
 *
 */
@Controller
public class HisController {

	@Autowired
	private HisServiceImpl hisServiceImpl;

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
	 * @throws Exception 
	 */

	@RequestMapping(method = RequestMethod.POST, value = "/insertUserData")
	public String insertUserData(Model model, RedirectAttributes redirectAttributes,
			@ModelAttribute("adminModel") @Valid AdminModel adminModel, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			initializerValues(model);
			return appProperties.getUserRegistration();
		}
		redirectAttributes.addFlashAttribute(appProperties.getMessage(), appProperties.getEnrollSuccess());
		initializerValues(redirectAttributes);
		hisServiceImpl.insertUserData(adminModel);
		return "redirect:/displayForm";
	}

	public String initializerValues(Model model) {

		List<?> list = hisServiceImpl.getRolesList();
		model.addAttribute("rolesList", list);
		List<String> gendersList = new ArrayList<String>();
		gendersList.add("Male");
		gendersList.add("FeMale");
		model.addAttribute("gendersList", gendersList);
		return appProperties.getUserRegistration();

	}

	@RequestMapping("/getAllAccounts")
	public String getallSsnRecords(Model model) {
		List<AdminModel> accountRecords = hisServiceImpl.getAllAccounts();
		model.addAttribute("accountRecords", accountRecords);
		return "getAllAccounts";

	}

	@GetMapping(value = "/email")
	public @ResponseBody String emailValidation(HttpServletRequest req) throws Exception {
		String email = null;
		String msg = null;
		email = req.getParameter("email");
		msg = hisServiceImpl.validateEmail(email);
		System.out.println("from controller"+msg);
		return msg;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/displayPlanForm")
	public String displayPlanForm(Model model) {
		model.addAttribute("planModel", new PlanModel());
		return "planForm";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/insertPlanData")
	public String insertPlanData(@ModelAttribute("planModel") PlanModel planModel,
			RedirectAttributes redirectAttributes, Model model) {
		redirectAttributes.addFlashAttribute("plan", "Plan registered Successfull");
		hisServiceImpl.insertPlanData(planModel);
		return "redirect:/displayPlanForm";
	}

	@RequestMapping("/getAllPlans")
	public String getAllPlans(Model model) {
		List<PlanModel> planRecords = hisServiceImpl.getAllPlans();
		model.addAttribute("planRecords", planRecords);
		return "getAllPlans";
	}
	
	@RequestMapping( value = "/statusInActive/{serialNumber}" , method = RequestMethod.GET)
	public String statusInActive(@PathVariable("serialNumber") Long serialNumber) {
		System.out.println("serial number is" +serialNumber);
		hisServiceImpl.statusInActive(serialNumber);
		return "redirect:/getAllAccounts";		
	}
	
	@RequestMapping( value = "/statusActive/{serialNumber}" , method = RequestMethod.GET)
	public String statusActive(@PathVariable("serialNumber") Long serialNumber) {
		System.out.println("serial number is" +serialNumber);
		hisServiceImpl.statusActive(serialNumber);
		return "redirect:/getAllAccounts";		
	}
	
	/*@RequestMapping( value = "/edit/{serialNumber}" , method = RequestMethod.GET)
	public String editAccountDetails(@PathVariable("serialNumber") Long serialNumber, Model model) {
		System.out.println("serial number is" +serialNumber);
		AdminModel adminModel =hisServiceImpl.editAccountDetails(serialNumber);
		model.addAttribute("adminModel",adminModel);
		System.out.println(model);
		return "redirect:/displayForm";		
	}*/
	
	@RequestMapping( value = "/edit/{serialNumber}" , method = RequestMethod.GET)
	public String editAccountDetails(@PathVariable("serialNumber") Long serialNumber, Model model,RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("serial number is" +serialNumber);
		AdminModel adminModel =hisServiceImpl.editAccountDetails(serialNumber);
		redirectAttributes.addFlashAttribute("adminModel",adminModel);
		//model.addAttribute("adminModel",adminModel);
		System.out.println(adminModel);
		return "edit";		
	}

}
