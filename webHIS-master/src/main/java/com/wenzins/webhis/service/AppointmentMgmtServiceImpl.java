package com.wenzins.webhis.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenzins.webhis.dao.AppointmentDAO;
import com.wenzins.webhis.entity.Appointment;


@Service
public class AppointmentMgmtServiceImpl implements AppointmentMgmtService {

	@Autowired
	private AppointmentDAO appointmentDAO;

	@Override
	@Transactional
	public Long setAppointment(Appointment appointment) {
		System.out.println("*************service");
		return appointmentDAO.setAppointment(appointment);
	}
	@Override
	@Transactional
	public List<Appointment> getAllAppointment() {
		return appointmentDAO.listAllAppointment();
	}
}

