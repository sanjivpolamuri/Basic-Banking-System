package com.mss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.mss.service.JobService;
import com.mss.entity.*;
@RestController
public class JobController {
   @Autowired
   JobService jobservice;
   @PostMapping("/jobinsert")
   public Map jobinsert(@RequestBody Job j) {
	   HashMap hm=new HashMap<>();
	   int i=jobservice.jobinsert(j);
	   if(i==1) {
		   hm.put("success", "job added");
	   }
	   else {
		   hm.put("failure","job not added");
	   }
	   return hm;   
   }
   
   @GetMapping("/joblist")
   public List joblist() {
	   return jobservice.joblists();
   }
   
   @PostMapping("/jobsapplied")
   public List jobsapplied(@RequestBody Job j) {
	   return jobservice.jobapplied(j);
   }
}
