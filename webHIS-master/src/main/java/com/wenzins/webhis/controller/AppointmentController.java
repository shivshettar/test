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

import com.wenzins.webhis.entity.Appointment;
import com.wenzins.webhis.entity.Login;
import com.wenzins.webhis.service.AppointmentMgmtService;

@Controller
@RequestMapping("/app")
public class AppointmentController {
	@Autowired
	AppointmentMgmtService appointmentMgmtService;
	
	
	@RequestMapping(value = "/appointment", method = RequestMethod.POST)
	@ResponseBody
	public void setAppointment(@RequestBody Appointment appointment) {
		
		System.out.println("**********controller");
		appointmentMgmtService.setAppointment(appointment);
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Appointment> getUser(ModelMap map) {
		System.out.println("Came inside this method >>>>  ::::  "
				+ appointmentMgmtService.getAllAppointment());
		return appointmentMgmtService.getAllAppointment();

	}
	

}