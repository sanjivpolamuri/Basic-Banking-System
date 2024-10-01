import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NewserviceService } from '../newservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  mylogin: any;
 ngOnInit(){
  this.mylogin=this.fb.group({
    email:['', [Validators.required,Validators.email]],
    password:['',Validators.required]

  })
}
  constructor(private fb: FormBuilder,private ser:NewserviceService,private router:Router){}
  submit(){
    localStorage.setItem('email', this.mylogin.get('email').value.toString());
   let data={
    email:this.mylogin.controls['email'].value,
    password:this.mylogin.controls['password'].value
   }
  
   this.ser.postdata(data).subscribe((res:any)=>{
         if(res.success=="admin"){
          alert("valid user");
          this.router.navigateByUrl('/admin/home');
         }
         else if(res.success=="user"){
          alert("valid user");
          this.router.navigateByUrl('/user/home');
         }
         else{
          alert("invalid user chech credentials")
         }
         this.mylogin.reset();
   });
   
  }
}
