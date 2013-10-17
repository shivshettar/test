package com.wenzins.webhis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wenzins.webhis.dao.LoginDAO;
import com.wenzins.webhis.entity.Login;
import com.wenzins.webhis.entity.Patient;

@Service
public class LoginMgmtServiceImpl implements LoginMgmtService {

	@Autowired
	private LoginDAO loginDAO;

	@Override
	@Transactional
	public Long loginUser(Login login) {
		return loginDAO.loginUser(login);
	}
	@Override
	@Transactional
	public List<Login> getAllUser() {
		return loginDAO.listAllUser();
	}
	
	public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
}
