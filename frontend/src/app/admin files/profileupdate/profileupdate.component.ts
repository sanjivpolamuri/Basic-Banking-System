import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, Subscriber } from 'rxjs';
import { NewserviceService } from 'src/app/newservice.service';

@Component({
  selector: 'app-profileupdate',
  templateUrl: './profileupdate.component.html',
  styleUrls: ['./profileupdate.component.css']
})
export class ProfileupdateComponent {
  constructor(private fb:FormBuilder,private ser:NewserviceService,private router:Router){}
 
 profile:any;
 myImage!:Observable<any>;
 base64code1!:any
 fileData: any;
 ngOnInit(){
  this.profile=this.fb.group({
    firstName:[''],
    lastName:[''],
    location:[''],
    yearOfPassing:[''],
    experience:[''],
    skills:[''],
    phoneNo:['',Validators.pattern('^[0-9]{10}$')],
  })
 }

 submit(){
   let data={
    firstName:this.profile.controls['firstName'].value,
    lastName:this.profile.controls['lastName'].value,
    email:localStorage.getItem('email'),
    location:this.profile.controls['location'].value,
    yearOfPassing:this.profile.controls['yearOfPassing'].value,
    experience:this.profile.controls['experience'].value,
    skills:this.profile.controls['skills'].value,
    phoneNo:this.profile.controls['phoneNo'].value,
    image:this.fileData
   }
   console.log(data);
   this.ser.profileupdate(data).subscribe((res:any)=>{
    if(res.success=="profile updated"){
      alert("profile updated successfully");
    }
    else{
      alert("profile is not updated");
    }
    this.profile.reset();
   })
 }
}
