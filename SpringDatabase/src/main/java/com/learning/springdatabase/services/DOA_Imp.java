package com.learning.springdatabase.services;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.learning.springdatabase.model.UserModel;

@Component
public class DOA_Imp implements IDOA 
{
	private DriverManagerDataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	String query = null;
	
	
	
	public boolean isConnected() 
	{
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
		if(dataSource!=null)
		{
			return true;
		}
		
		return false;
	}

	public int insertData(UserModel model) 
	{
		int rowsaffected = 0;
		if(isConnected())
		{
			query = "insert into student values (?,?,?)";
			 rowsaffected = jdbcTemplate.update(query,model.getId(),model.getName(),model.getAddress());
		}
		return rowsaffected;
	}

	
	
}
