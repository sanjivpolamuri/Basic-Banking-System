import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class NewserviceService {

  constructor(private http:HttpClient) {}
 public postdata(data:any){
   return this.http.post("http://localhost:8080/loginvalidate",data)
 }
 public forgetpswd(data:any){
  return this.http.put("http://localhost:8080/forgetpassword",data)
 }
 public postuserdata(data:any){
  return this.http.post("http://localhost:8080/logininsert",data)
 }
 public postprofile(data:any){
  return this.http.post("http://localhost:8080/profileinsert",data)
 }
 public profiledata(data:any){
  return this.http.post("http://localhost:8080/profiledata",data)
 }
 public joblist(){
  return this.http.get("http://localhost:8080/joblist");
 }
 public postjob(data:any){
  return this.http.post("http://localhost:8080/jobinsert",data);
 }
 public postapplication(data:any){
  return this.http.post("http://localhost:8080/aplplicationinsert",data);
 }
 public appliedjobs(data:any){
  return this.http.post("http://localhost:8080/applicantlist",data);
 }
 public jobsapplied(data:any){
  return this.http.post("http://localhost:8080/jobsapplied",data);
 }
 public applistatus(data:any){
  return this.http.put("http://localhost:8080/statusupdate",data);
 }
 public imageretrive(data:any){
  return this.http.post("http://localhost:8080/imageretrieve",data);
 }
 public profileupdate(data:any){
  return this.http.put("http://localhost:8080/updatingprofile",data);
 }
}
