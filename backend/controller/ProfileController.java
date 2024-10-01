package com.mss.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.mss.entity.Login;
import com.mss.entity.Profile;
import com.mss.service.ProfileService;
@RestController
public class ProfileController {
  //inserting the data
  @Autowired
  ProfileService profileService;
  @PostMapping("/profileinsert")
  public Map profileinsert(@RequestBody Profile p) {
	   HashMap hm=new HashMap<>();
	   int i=profileService.profileinsert(p);
	   if(i==1) {
		   hm.put("success","data insert successfully");
	   }
	   else {
		   hm.put("failure", "data not inserted");
	   }
	   return hm;   
  }
  
  //updating the profile
  @PutMapping("/updatingprofile")
  public Map profileupdate(@RequestBody Profile p) {
	   HashMap hm=new HashMap<>();
	   int i=profileService.profileupdate(p);
	   if(i==1) {
		   hm.put("success","profile updated");
	   }
	   else {
		   hm.put("failure", "profile is not updated");
	   }
	   return hm;   
 }
  
  //feteching the profile details
  @PostMapping("/profiledata")
  public List profileretrieve(@RequestBody Profile p) {
	  return profileService.profileretrieve(p);
  }
  
  //deleting the profile 
  @DeleteMapping("/Accountdelete")
  public Map profiledelete(@RequestBody Profile p) {
	  HashMap hm=new HashMap<>();
	   int i=profileService.profiledelete(p);
	   if(i==1) {
		   hm.put("success","Account deleated");
	   }
	   else {
		   hm.put("failure", "Account is not deleted");
	   }
	   return hm;  
  }
  
  @PostMapping("/imageretrieve")
  public List imageretrieve(@RequestBody Profile p) {
	  return profileService.imageretrieve(p);
  }
}
