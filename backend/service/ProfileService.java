package com.mss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.*;

import com.mss.entity.Profile;
@Service
public class ProfileService {
    @Autowired
    JdbcTemplate jdbcTemplate;
	public int profileinsert(Profile p) {
		String sql="insert into profile(firstName,lastName,email,location,image,yearOfPassing,experience,skills,gender,phoneNo) values(?,?,?,?,?,?,?,?,?,?)";
		int i=jdbcTemplate.update(sql,p.getFirstName(),p.getLastName(),p.getEmail(),p.getLocation(),p.getImage(),p.getYearOfPassing(),p.getExperience(),p.getSkills(),p.getGender(),p.getPhoneNo());
		return i;
	}
	
	public int profileupdate(Profile p) {
		String sql="update profile set ";
		int valuei;
		if(!(p.getFirstName().equals(""))) {
			sql+="firstName='"+p.getFirstName()+"',";
		}
		if(!(p.getLastName().equals(""))) {
			sql+="lastName='"+p.getLastName()+"',";
		}
		if(!(p.getLocation().equals(""))) {
			sql+="location='"+p.getLocation()+"',";
		}
		if(p.getYearOfPassing() != 0) {
			sql+="yearOfPassing='"+p.getYearOfPassing()+"',";
		}
		if(p.getExperience() != 0) {
			sql+="experience='"+p.getExperience()+"',";
		}
		if(!(p.getSkills().equals(""))){
			sql+="skills='"+p.getSkills()+"',";
		}
//		if(!(p.getGender().equals(""))){
//			sql+="gender='"+p.getGender()+"',";
//		}
		if(p.getPhoneNo()!=0) {
			sql+="phoneNo"+p.getPhoneNo()+"',";
		}
		sql=sql.substring(0,sql.length()-1);
		sql+=" where email=?";
		System.out.println(sql);
		return jdbcTemplate.update(sql,p.getEmail());
	}
	
	public List profileretrieve(Profile p) {
		List listdata=new ArrayList<>();
		HashMap getdata=null;
		String sql="select * from profile p inner join registration j where p.email=j.email and p.email=?";
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=jdbcTemplate.queryForList(sql,p.getEmail());
		for(Map newdata:data) {
			getdata=new HashMap<>();
			String role=(String) newdata.get("role");
			if(role.equals("admin")) {
				getdata.put("firstName", newdata.get("firstName"));
				getdata.put("lastName", newdata.get("lastName"));
				getdata.put("location", newdata.get("location"));
				getdata.put("gender", newdata.get("gender"));
				getdata.put("image", newdata.get("image"));
				getdata.put("phoneNo", newdata.get("phoneNo"));

			}
			else {
				getdata.put("firstName", newdata.get("firstName"));
				getdata.put("lastName", newdata.get("lastName"));
				getdata.put("location", newdata.get("location"));
				getdata.put("yearOfPassing", newdata.get("yearOfPassing"));
				getdata.put("experience", newdata.get("experience"));
				getdata.put("skills", newdata.get("skills"));
				getdata.put("gender", newdata.get("gender"));
				getdata.put("image", newdata.get("image"));
				getdata.put("phoneNo", newdata.get("phoneNo"));
			}			
			listdata.add(getdata);
		}
		return listdata;
	}

	public int profiledelete(Profile p) {
		String sql="delete from profile where email=?";
		int i=jdbcTemplate.update(sql,p.getEmail());
		if(i==1) {
			String sql1="delete from registration where email=?";
			return jdbcTemplate.update(sql1,p.getEmail());
		}
		else {
		    return 0;
		}
	}

	public List imageretrieve(Profile p) {
		List listdata=new ArrayList<>();
		HashMap getdata=null;
		String sql="select * from profile where email=?";
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		data=jdbcTemplate.queryForList(sql,p.getEmail());
		for(Map newdata:data) {
			getdata=new HashMap<>();	
			getdata.put("image", newdata.get("image"));
			listdata.add(getdata);
		}
		return listdata;
	}
}
