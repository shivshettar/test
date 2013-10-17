package com.wenzins.webhis.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wenzins.webhis.dao.*;
import com.wenzins.webhis.entity.Login;

public class TestLoginDao {
	
	private LoginDAO loginDAO = new LoginDaoImpl();
	private Login login;
	
	@Before
	public void createLogin() {
		
		login = new Login();
		login.setUserName("niranjan");
		login.setPassword("hello");
		System.out.println("here in createUser"+login);	
		
		loginDAO = new LoginDAO() {
			
			//private Object sessionFactory;

			@Autowired
			private Session session;
			private SessionFactory sessionFactory;
			
			@Override
			public Long loginUser(Login login) {
				System.out.println("here in login user"+login);
				// TODO Auto-generated method stub
				return 12345L;
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Login> listAllUser() {
				// TODO Auto-generated method stub
				//return null;
				System.out.println(this.sessionFactory);
			List<Login> userList = ((SessionFactory) this.sessionFactory).getCurrentSession().createQuery("from Login").list();
						return userList;
			}
		};
	}
	
	@Ignore
	public void testDAOLoginUser() throws Exception{
		System.out.println("here in test"+login);
		Long retVal = loginDAO.loginUser(login);
		assertNotNull(retVal);
		Assert.assertEquals(12345L, retVal.longValue());
	}
	
	@Ignore 
	public void testDAOListAllUser(){
		List<Login> users = loginDAO.listAllUser();
		assertNotNull(users);
	}
	
	@Test
	public void test()throws Exception {
		
		  List<Login> peopleList = new ArrayList<Login>();
		  	Login login=new Login();
		      login.setUserName("raju");
		      login.setPassword("ram");
		      peopleList.add(login);
		      //Populates data
		      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		      
		          for (Login l : peopleList) {
		                 session.save(l);
		      
		          }
		          session.flush();
		          //verifies results
		          LoginDAO dao = new LoginDaoImpl();
		          
		              dao.listAllUser();
		          
		              assertEquals(peopleList, dao.listAllUser());
		      

	}
}
	
	
	/*
	
	
	
	
	
	
	
	
	
		public Login login;
	 @Before
		public void CreateLogin(){
		 	login = new Login();
		 	login.setUserName("niranjan");
			login.setPassword("xyz");
			System.out.println("here!!");
			LoginDAO loginDao = new LoginDAO() {
				//	Session session;
				@Autowired
				private Session session;
				private SessionFactory sessionFactory;
				
				@Override
				public Long loginUser(Login login) {
		//			logger.info("Inside the loginUser method : "+login);
					login.setLoginId(12345L);
					System.out.println(login.getLoginId());
					System.out.println("Inside the loginUser method : "+login);
					
					Long lRet = (Long)this.sessionFactory.getCurrentSession().save(login);
					System.out.println("Returning :"+lRet);
					return lRet;
				}
		
				@Override
				public List<Login> listAllUser() {
			// 	TODO Auto-generated method stub
					return null;
				}
				@Override
			public Session getSession()
			{
			return session;
			}
			};
		}
	 
	@Test
	public void TestDao() throws Exception {
	login = new Login();
	login.setUserName("niranjan");
	login.setPassword("xyz");	
	LoginDAO loginDao = null;
	Long ret = loginDao.loginUser(login);
	System.out.println("return value:"+ret);
	assertNotNull(ret);
	//fail("Not yet implemented");
	}
	

	
	
	@Test 
	public void TestSession(){
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		ApplicationContext appContext = new AnnotationConfigApplicationContext("com.wenzins.webhis.controller");
		LoginDAO loginDAO = (LoginDAO) appContext.getBean("LoginDAO");
		Session sess = loginDAO.getSession();
		assertEquals(session, sess);
	}

}
*/