package com.wenzins.webhis.controller;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenzins.webhis.entity.DoctorDetails;
import com.wenzins.webhis.entity.DepartmentDetails;
import com.wenzins.webhis.service.DoctorMgmtService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorMgmtService doctorMgmtService;
	Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
	@ResponseBody
	public void InsertDoctorDetails(@RequestBody DoctorDetails doctordetails) {
		
		logger.info("***********************Inside the login controller method");
		
		logger.info("***********************Inside the controller method");
	
		doctorMgmtService.InsertDoctorDetails(doctordetails);
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<DoctorDetails> listAllDoctor(ModelMap map) {
		System.out.println("Came inside this method >>>>  ::::  "
				+ doctorMgmtService.listAllDoctor());
		List<DoctorDetails> li=doctorMgmtService.listAllDoctor();
		
		return li;

	}
	
	@RequestMapping(value = "/listdep", method = RequestMethod.GET)
	public @ResponseBody
	List<DepartmentDetails> listAllDepartment(ModelMap map) {
		System.out.println("Came inside this method department >>>>  ::::  "
				+ doctorMgmtService.listAllDepartment());
		List<DepartmentDetails> li=doctorMgmtService.listAllDepartment();
		System.out.println("Came inside this method department"+li);
		return li;

	}


}
