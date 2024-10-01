import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Observable, Subscriber } from 'rxjs';
import { NewserviceService } from '../newservice.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
 constructor(private fb:FormBuilder,private ser:NewserviceService,private router:Router){}
 
 profile:any;
 myImage!:Observable<any>;
 base64code1!:any
 fileData: any;
 ngOnInit(){
  this.profile=this.fb.group({
    firstName:['',Validators.required],
    lastName:['',Validators.required],
    location:['',Validators.required],
    yearOfPassing:['', Validators.required],
    experience:['', Validators.required],
    skills:['',Validators.required],
    gender:['',Validators.required],
    phoneNo:['',[Validators.required,Validators.pattern('^[0-9]{10}$')]],
    file:[null, Validators.required]
  })
 }

 onChange =($event: Event)=>{
  const target=$event.target as HTMLInputElement;
  const file:File = (target.files as FileList)[0];
  this.convertToBase64(file);
}
convertToBase64(file: File){
  const observable = new Observable((subscriber: Subscriber<any>)=>{
    this.readFile(file,subscriber)
  })
  observable.subscribe((d)=>{
    this.fileData=d
    this.fileData=this.fileData.substring(this.fileData.indexOf(',')+1,this.fileData.length);
  })
}
readFile(file : File,subscriber:Subscriber<any>){
  const filereader = new FileReader();
  filereader.readAsDataURL(file);
  filereader.onload = () => {
    subscriber.next(filereader.result);
    subscriber.complete()
  }
  filereader.onerror = ()=>{
    subscriber.error()
    subscriber.complete()
  }
}


 submit(){
   let data={
    firstName:this.profile.controls['firstName'].value,
    lastName:this.profile.controls['lastName'].value,
    email:localStorage.getItem('useremail'),
    location:this.profile.controls['location'].value,
    yearOfPassing:this.profile.controls['yearOfPassing'].value,
    experience:this.profile.controls['experience'].value,
    skills:this.profile.controls['skills'].value,
    gender:this.profile.controls['gender'].value,
    phoneNo:this.profile.controls['phoneNo'].value,
    image:this.fileData
   }
   console.log(this.fileData);
   this.ser.postprofile(data).subscribe((res:any)=>{
    if(res.success=="data insert successfully"){
      alert("profile is added");
      this.router.navigateByUrl("/login");
    }
    else{
      alert("please check the details again");
    }
   })
 }
}
