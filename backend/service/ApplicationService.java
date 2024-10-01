package com.mss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import com.mss.entity.Application;
@Service
public class ApplicationService {
    @Autowired
    JdbcTemplate jdbcTemplate;
	public int applicationinsert(Application a) {
		int i=validate(a.getEmail(),a.getJobId());
		if(i==1) {
			return 0;
		}else {
			LocalDateTime dateApplied=LocalDateTime.now();
			String sql="insert into application(email,status,companyId,jobId,dateApplied) values(?,?,?,?,?)";
			return jdbcTemplate.update(sql,a.getEmail(),a.getStatus(),a.getCompanyId(),a.getJobId(),dateApplied);	
		}
	}
	
	public int validate(String email,int jobId) {
		String sql="select count(*) from application where email='"+email+"' and jobId="+jobId;
		int i=jdbcTemplate.queryForObject(sql, Integer.class);
		return i;
		
	}
	public List applicantlist(Application a) {
		List datalist=new ArrayList<>();
		HashMap getdata=null;
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		String sql="select * from jobs j inner join application a where a.jobId=j.id and a.email=?";
		data=jdbcTemplate.queryForList(sql,a.getEmail());
		for(Map newdata:data) {
			getdata=new HashMap<>();
			getdata.put("jobId", newdata.get("jobId"));
			getdata.put("title", newdata.get("title"));
			getdata.put("companyId", newdata.get("companyId"));
			getdata.put("jobType", newdata.get("jobType"));
			getdata.put("location", newdata.get("location"));
			getdata.put("salary", newdata.get("salary"));
			getdata.put("companyName", newdata.get("companyName"));
			getdata.put("jobSkills", newdata.get("jobSkills"));
			getdata.put("status", newdata.get("status"));
			datalist.add(getdata);
		}
		return datalist;
	}

	public int statusupdate(Application a) {
		String sql="update application set status=? where applicationId=?";
		return jdbcTemplate.update(sql,a.getStatus(),a.getApplicationId());
	}
	

}
