package com.wenzins.webhis.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.wenzins.webhis.entity.Login;


@Repository
public class LoginDaoImpl implements LoginDAO {

		
	@Autowired
	private Session session;
	private SessionFactory sessionFactory;
	Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Override
	public Long loginUser(Login login) {
		logger.info("Inside the loginUser method : "+login);
		System.out.println("Inside the loginUser method : "+login);
		
		return (Long)this.sessionFactory.getCurrentSession().save(login);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Login> listAllUser() {
		List<Login> userList = this.sessionFactory.getCurrentSession()
		.createQuery("from Login").list();
		return userList;
	}
	
	//LoginDAOImpl for configuring database
	
	
    private BasicDataSource dataSource;

 

    public void setDataSource(BasicDataSource dataSource) {

        this.dataSource = dataSource;

    }

 

    public int insert(Login login) {

        try {

            Connection conn = (Connection) dataSource.getConnection("root", "wenzins");

            String sql = "INSERT INTO logindetails VALUES (?, ?)";

 

            
// Creates a statement and asks it to return generated Ids

            PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"LOGIN_ID"});
            		//.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, login.getUserName());

            stmt.setString(2, login.getPassword());

 

            
// Executes the statement and retrieve the generated Id
	            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            int personId = rs.getBigDecimal(1).intValue();

 

            rs.close();

            stmt.close();

            conn.close();

            return personId;
	        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }
/*	@Override
	public Session getSession()
	{
		return session;
	}
	*/
}