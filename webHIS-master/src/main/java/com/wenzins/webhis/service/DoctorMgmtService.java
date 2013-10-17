package com.wenzins.webhis.service;
import java.util.List;

import com.wenzins.webhis.entity.DoctorDetails;
import com.wenzins.webhis.entity.DepartmentDetails;

public interface DoctorMgmtService {

	
	public Long InsertDoctorDetails(DoctorDetails doctordetails);
	public List<DoctorDetails> listAllDoctor();
	public List<DepartmentDetails> listAllDepartment();
}
