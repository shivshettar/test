package com.wenzins.webhis.dao;

import java.util.List;

import com.wenzins.webhis.entity.DepartmentDetails;
import com.wenzins.webhis.entity.DoctorDetails;
public interface DepartmentDAO {
	public Long InsertDepartmentDetails(DepartmentDetails departmentdetails);
	public List<DepartmentDetails> listAllDepartment();
	public List<DoctorDetails> listAllDoctor();
}