package com.wenzins.webhis.service;
import java.util.List;

import com.wenzins.webhis.entity.DepartmentDetails;
import com.wenzins.webhis.entity.DoctorDetails;


public interface DepartmentMgmtService {

	
	public Long InsertDepartmentDetails(DepartmentDetails departmentdetails);
	public List<DepartmentDetails> listAllDepartment();
	public List<DoctorDetails> listAllDoctor();
}
