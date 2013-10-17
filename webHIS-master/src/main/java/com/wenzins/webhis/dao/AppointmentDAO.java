package com.wenzins.webhis.dao;

import java.util.List;

import com.wenzins.webhis.entity.Appointment;

public interface AppointmentDAO {
	public Long setAppointment(Appointment appointment);
	public List<Appointment> listAllAppointment();
}
