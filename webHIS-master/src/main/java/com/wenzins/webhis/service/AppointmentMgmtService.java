package com.wenzins.webhis.service;


import java.util.List;

import com.wenzins.webhis.entity.Appointment;

public interface AppointmentMgmtService {

	
	public Long setAppointment(Appointment appointment);
	public List<Appointment> getAllAppointment();
}
