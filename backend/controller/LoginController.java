package com.mss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.mss.entity.Login;
import com.mss.service.LoginService;

@RestController
public class LoginController {
   //inserting the data
   @Autowired
   LoginService loginService;
   @PostMapping("/logininsert")
   public Map logininsert(@RequestBody Login l) {
	   HashMap hm=new HashMap<>();
	   int i=loginService.logininsert(l);
	   if(i==1) {
		   hm.put("success","data insert successfully");
	   }
	   else {
		   hm.put("failure", "data not inserted");
	   }
	   return hm;   
   }
   
   //validating the user
   @PostMapping("/loginvalidate")
   public Map loginvalidate(@RequestBody Login l) {
	   HashMap hm=new HashMap<>();
	   String role=loginService.loginvalidate(l);
	   if(role!=null) {
		   hm.put("success",role);
	   }
	   else {
		   hm.put("failure","invalid user");
	   }
	   return hm;
   }
   
   //updating the password field
  @PutMapping("/forgetpassword")
  public Map forgetpassword(@RequestBody Login l) {
	   HashMap hm=new HashMap<>();
	   int i=loginService.forgetpassword(l);
	   if(i==1) {
		   hm.put("success","password updated");
	   }
	   else {
		   hm.put("failure", "password is not updated");
	   }
	   return hm;   
  }
}
