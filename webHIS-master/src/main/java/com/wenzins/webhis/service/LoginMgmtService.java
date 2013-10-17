package com.wenzins.webhis.service;
import java.util.List;

import com.wenzins.webhis.dao.LoginDAO;
import com.wenzins.webhis.entity.Login;
import com.wenzins.webhis.entity.Patient;

public interface LoginMgmtService {

	
	public Long loginUser(Login login);
	public List<Login> getAllUser();
	public void setLoginDAO(LoginDAO loginDAO);
	}