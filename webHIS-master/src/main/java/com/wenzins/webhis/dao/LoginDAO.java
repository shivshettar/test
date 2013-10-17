package com.wenzins.webhis.dao;

import java.util.List;

import org.hibernate.Session;

import com.wenzins.webhis.entity.Login;
import com.wenzins.webhis.entity.Patient;

public interface LoginDAO {
	public Long loginUser(Login login);
	public List<Login> listAllUser();
//	Session getSession();
}