package com.wenzins.webhis.dao;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wenzins.webhis.entity.DepartmentDetails;
import com.wenzins.webhis.entity.DoctorDetails;


@Repository
public class DoctorDaoImpl implements DoctorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Override
	public Long InsertDoctorDetails(DoctorDetails doctordetails) {
		
		
		return (Long)this.sessionFactory.getCurrentSession().save(doctordetails);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DoctorDetails> listAllDoctor(){
		List<DoctorDetails> List = this.sessionFactory.getCurrentSession()
		.createQuery("from DoctorDetails").list();
		return List;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	
	public List<DepartmentDetails> listAllDepartment(){
		List<DepartmentDetails> List = this.sessionFactory.getCurrentSession()
				.createQuery("from DepartmentDetails").list();
				return List;
		
	}
}
