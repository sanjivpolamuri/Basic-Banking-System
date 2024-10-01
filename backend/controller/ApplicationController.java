package com.mss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import java.util.*;
import com.mss.entity.Application;
import com.mss.service.ApplicationService;

@RestController
public class ApplicationController {
  @Autowired
  ApplicationService applicationService;
  
  @PostMapping("/aplplicationinsert")
  public Map applicationinsert(@RequestBody Application a) {
	  HashMap hm=new HashMap<>();
	  int i=applicationService.applicationinsert(a);
	  if(i==1) {
		  hm.put("success", "applied for job");
	  }
	  else {
		  hm.put("failure","Already applied");
	  }
	  return hm;
  }
  
  
  @PostMapping("/applicantlist")
  public List applicantlist(@RequestBody Application a) {
	  return applicationService.applicantlist(a);
  }
  
  @PutMapping("/statusupdate")
  public Map statusupdate(@RequestBody Application a) {
	  HashMap hm=new HashMap<>();
	  int i=applicationService.statusupdate(a);
	  if(i==1) {
		  hm.put("success", "status updated");
	  }
	  else {
		  hm.put("failure", "please select any value");
	  }
	  return hm;
  }
}
