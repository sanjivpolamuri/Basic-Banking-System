package com.mss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.*;
import com.mss.entity.Login;
@Service
public class LoginService {
    @Autowired
    JdbcTemplate jdbcTemplate;
	public int logininsert(Login l) {
		String sql="insert into registration(username,email,password,role) values(?,?,?,?)";
		int i=jdbcTemplate.update(sql,l.getUserName(),l.getEmail(),l.getPassword(),l.getRole());
		return i;
	}
	
	public String loginvalidate(Login l) {
		String email=l.getEmail();
		String password=l.getPassword();
		String sql="select count(*) from registration where email='"+email+"' and password='"+password+"'";
		int i=jdbcTemplate.queryForObject(sql,Integer.class);
		if(i==1) {
		    return gettingrole(email,password);
		}
		else {
		  return null;
		}
	}
	
	private String gettingrole(String email, String password) {
		HashMap data=null;
		List<Map<String,Object>> getdata=new ArrayList<Map<String,Object>>();
		String sql="select * from registration where email=? and password=?";
		getdata=jdbcTemplate.queryForList(sql,email,password);
		for(Map newdata:getdata) {
			data=new HashMap();
			data.put("role", newdata.get("role"));
		}
		return (String) data.get("role");
	}
	
	public int forgetpassword(Login l) {
		String sql =null;
		if(!(l.getPassword().equals(""))) {
			sql="update registration set password=? where email=?";
			int i=jdbcTemplate.update(sql,l.getPassword(),l.getEmail());
			System.out.println(i);
			return i;
		}
		else {
		  return 0;
		}
	}

}
