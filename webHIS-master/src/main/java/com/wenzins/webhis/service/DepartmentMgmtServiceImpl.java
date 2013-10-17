package com.wenzins.webhis.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenzins.webhis.dao.DepartmentDAO;
import com.wenzins.webhis.entity.DepartmentDetails;
import com.wenzins.webhis.entity.DoctorDetails;
;

@Service
public class DepartmentMgmtServiceImpl implements DepartmentMgmtService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	@Transactional
	public Long InsertDepartmentDetails( DepartmentDetails  departmentdetails){
		return departmentDAO.InsertDepartmentDetails( departmentdetails);
	}
	@Override
	@Transactional
	public List<DepartmentDetails> listAllDepartment() {
		return departmentDAO.listAllDepartment();
	}
	@Override
	@Transactional
	public List<DoctorDetails> listAllDoctor(){
		return departmentDAO.listAllDoctor();
	}
}
