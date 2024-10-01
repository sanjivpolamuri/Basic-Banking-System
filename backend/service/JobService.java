package com.mss.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.*;
import com.mss.entity.Job;
@Service
public class JobService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
	public int jobinsert(Job j) {
		LocalDateTime datePosted = LocalDateTime.now();
		String sql="insert into jobs(title,companyId,jobType,location,salary,companyName,"
				+ "jobSkills,datePosted,email) values(?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,j.getTitle(),j.getCompanyId(),j.getJobType(),j.getLocation(),j.getSalary(),j.getCompanyName(),j.getJobSkills(),datePosted,j.getEmail());
	}

	public List joblists() {
		List listdata=new ArrayList<>();
		HashMap getdata=null;
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		String sql="select * from jobs";
		data=jdbcTemplate.queryForList(sql);
		for(Map newdata:data) {
			getdata=new HashMap<>();
			getdata.put("id",newdata.get("id"));
			getdata.put("title", newdata.get("title"));
			getdata.put("companyId", newdata.get("companyId"));
			getdata.put("jobType", newdata.get("jobType"));
			getdata.put("location", newdata.get("location"));
			getdata.put("salary", newdata.get("salary"));
			getdata.put("companyName", newdata.get("companyName"));
			getdata.put("jobSkills", newdata.get("jobSkills"));
			getdata.put("datePosted", newdata.get("datePosted"));
			listdata.add(getdata);
		}
		return listdata;
	}
	
	public List jobapplied(Job j) {
		List listdata=new ArrayList<>();
		HashMap getdata=null;
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		String sql="select * from application a inner join jobs j on a.jobId=j.id inner join profile p on p.email=a.email where j.email=?";
		data=jdbcTemplate.queryForList(sql,j.getEmail());
		for(Map newdata:data) {
			getdata=new HashMap<>();
			getdata.put("applicationId", newdata.get("applicationId"));
			getdata.put("companyName",newdata.get("companyName"));
			getdata.put("title", newdata.get("title"));
			getdata.put("jobType", newdata.get("jobType"));
			getdata.put("firstName", newdata.get("firstName"));
			getdata.put("lastName", newdata.get("lastName"));
			getdata.put("email", newdata.get("email"));
			getdata.put("skills", newdata.get("skills"));
			getdata.put("experience", newdata.get("experience"));
			getdata.put("dateApplied",newdata.get("dateApplied"));
			listdata.add(getdata);
		}
		return listdata;
	}

}
