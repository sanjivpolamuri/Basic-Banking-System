package com.mss.entity;

import java.time.LocalDateTime;

public class Application {
 private int applicationId;
 private String email;
 private String status;
 private int companyId;
 private int jobId;
 private LocalDateTime dateApplied;

public int getApplicationId() {
	return applicationId;
}
public void setApplicationId(int applicationId) {
	this.applicationId = applicationId;
}
public String getEmail() {
	return email;	
}
public void setEmail(String email) {
	this.email = email;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getCompanyId() {
	return companyId;
}
public void setCompanyId(int companyId) {
	this.companyId = companyId;
}
public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public LocalDateTime getDateApplied() {
	return dateApplied;
}
public void setDateApplied(LocalDateTime dateApplied) {
	this.dateApplied = dateApplied;
}
 
}
