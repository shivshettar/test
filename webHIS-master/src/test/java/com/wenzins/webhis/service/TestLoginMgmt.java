package com.wenzins.webhis.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import com.wenzins.webhis.dao.*;
import com.wenzins.webhis.entity.Login;

import org.junit.Before;
import org.junit.Test;

public class TestLoginMgmt {
	private LoginMgmtService loginMgmtService = new LoginMgmtServiceImpl();
	private Login login;
	
	@Before
	public void createLogin() {
		login = new Login();
		login.setUserName("niranjan");
		login.setPassword("hello");
		System.out.println("here in createUser"+login);	
		
		loginMgmtService.setLoginDAO(new LoginDAO() {
			
			@Override
			public Long loginUser(Login login) {
				// TODO Auto-generated method stub
				System.out.println("here in loginUser"+login);	
				return 12345L;
			}
			
			@Override
			public List<Login> listAllUser() {
				// TODO Auto-generated method stub
				List<Login> users =  new ArrayList<Login>();
				Login user = new Login();
				user.setUserName("niranjan");
				user.setPassword("all is well");
				users.add(user);
				
				return users;	
			//	return null;
			}
		});
	}
	
	@Test
	public void testLoginUser() throws Exception{
		System.out.println("here in test"+login);
		Long retVal = loginMgmtService.loginUser(login);
		assertNotNull(retVal);
		Assert.assertEquals(12345L, retVal.longValue());
	}
	
	@Test
	public void testGetUser() throws Exception{
	List<Login> list = loginMgmtService.getAllUser();
		Assert.assertNotNull(list);
	}
	

}
