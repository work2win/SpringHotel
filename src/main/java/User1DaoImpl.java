package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.User1;

public class User1DaoImpl implements User1Dao{
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void register(User1 user){
		
		System.out.println("username:"+user.getUsername()+"password:"+user.getPassword());
		System.out.println("this works");
		
		String sql = "insert into user1 values(?,?)";
		
		jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword() });
	}
	
	class UserMapper implements RowMapper<User1>{
		public User1 mapRow(ResultSet rs, int arg1) throws SQLException {
			
			User1 user = new User1();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	}
	

}
