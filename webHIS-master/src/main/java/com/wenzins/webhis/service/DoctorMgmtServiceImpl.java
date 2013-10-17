package com.wenzins.webhis.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenzins.webhis.dao.DoctorDAO;
import com.wenzins.webhis.entity.DepartmentDetails;
import com.wenzins.webhis.entity.DoctorDetails;
;

@Service
public class DoctorMgmtServiceImpl implements DoctorMgmtService {

	@Autowired
	private DoctorDAO doctorDAO;

	@Override
	@Transactional
	public Long InsertDoctorDetails(DoctorDetails doctordetails){
		return doctorDAO.InsertDoctorDetails(doctordetails);
	}
	@Override
	@Transactional
	public List<DoctorDetails> listAllDoctor() {
		return doctorDAO.listAllDoctor();
	}
	
	 public List<DepartmentDetails> listAllDepartment(){
	            return doctorDAO.listAllDepartment();
	 }
}

