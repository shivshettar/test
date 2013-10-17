package com.wenzins.webhis.controller;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import com.wenzins.webhis.dao.LoginDAO;
import com.wenzins.webhis.entity.Login;
import com.wenzins.webhis.service.LoginMgmtService;

public class TestLoginController {

	private LoginController loginController = new LoginController();
	private Login login;		

	@Before
	public void createLogin() {
		login = new Login();
		login.setUserName("johndoe");
		login.setPassword("welcome");
		loginController.setLoginMgmtService(new LoginMgmtService() {
			
			@Override
			public Long loginUser(Login login) {
				// TODO Auto-generated method stub
				return 12345L;
			}
			
			@Override
			public List<Login> getAllUser() {
				List<Login> users =  new ArrayList<Login>();
				Login user1 = new Login();
				user1.setUserName("niranjan");
				user1.setPassword("lDEF6BIoaJ6E0Rd3TmAmfw==");
				users.add(user1);
				
				return users;
			}

			@Override
			public void setLoginDAO(LoginDAO loginDAO) {
				// TODO Auto-generated method stub
				
			}

			
		});
	}

	@Test
	public void testLoginUser() throws Exception {

		Long loginId = loginController.loginUser(login);
		Assert.assertNotNull(login.getUserName());
		Assert.assertEquals("johndoe", login.getPassword());
	}
	
	@Test
	public void testEncryptPassword() throws Exception{
		String encryptedPassword = LoginController.encryptpass("welcome");
	//	String pass="lDEF6BIoaJ6E0Rd3TmAmfw==";
		String decryptedPassword = LoginController.decryptpass(encryptedPassword);
		
		Assert.assertEquals("welcome", decryptedPassword);
		
		}
	
	@Test
	public void testGetUser() throws Exception{
	List<Login> list = loginController.getUser(null);
		Assert.assertNotNull(list);
	}

}
