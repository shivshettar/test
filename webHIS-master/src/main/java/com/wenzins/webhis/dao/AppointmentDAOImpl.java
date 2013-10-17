package com.wenzins.webhis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wenzins.webhis.entity.Appointment;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public Long setAppointment(Appointment appointment) {
		System.out.println("************DAO,"+appointment);
		return (Long)this.sessionFactory.getCurrentSession().save(appointment);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> listAllAppointment() {
		List<Appointment> userList = this.sessionFactory.getCurrentSession()
		.createQuery("from Appointment").list();
		return userList;
	}
}
