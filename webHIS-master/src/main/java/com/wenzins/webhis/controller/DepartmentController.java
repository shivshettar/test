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

import com.wenzins.webhis.entity.DepartmentDetails;
import com.wenzins.webhis.entity.DoctorDetails;
import com.wenzins.webhis.service.DepartmentMgmtService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentMgmtService departmentMgmtService;
	Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public Long InsertDepartmentDetails(@RequestBody DepartmentDetails departmentdetails) {
		
		logger.info("***********************Inside the department controller method");
		
		logger.info("***********************Inside the controller method");
	
		departmentMgmtService.InsertDepartmentDetails(departmentdetails);
		Long id= departmentdetails.getDepId();
		
		return id;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<DepartmentDetails> listAllDepartment(ModelMap map) {
		System.out.println("Came inside this method >>>>  ::::  "
				+ departmentMgmtService.listAllDepartment());
		List<DepartmentDetails> li=departmentMgmtService.listAllDepartment();
		
		return li;

	}
	@RequestMapping(value = "/listdoc", method = RequestMethod.GET)
	public @ResponseBody
	List<DoctorDetails> listAllDoctor(ModelMap map) {
		System.out.println("Came inside this method >>>>  ::::  "
				+ departmentMgmtService.listAllDoctor());
		List<DoctorDetails> li=departmentMgmtService.listAllDoctor();
		
		return li;

	}


}
