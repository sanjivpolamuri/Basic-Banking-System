import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NewserviceService } from '../newservice.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  SignUp:any
  constructor(private formBuilder: FormBuilder, private router: Router,private ser:NewserviceService){}
  ngOnInit(){
    this.SignUp = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', [Validators.required,Validators.minLength(8),Validators.maxLength(12),this.passwordvalidate]],
      conformpassword:['', [Validators.required,Validators.minLength(8),Validators.maxLength(12)]],
      role: ['',Validators.required],
      email: ['', [Validators.required, Validators.email]]
    },
    { 
      validators:this.mustmatch('password','conformpassword')
    });
  }
   
  passwordvalidate(control:FormControl): { [key: string]: boolean } | null {
    const password = control.value;
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;
    if (!regex.test(password)) {
      return { 'passwordRequirements': true };
    }
    return null;
    }
  
    mustmatch(controlname:string,matchingcontrolname:string){
      return(formGroup: FormGroup)=>{
          const control=formGroup.controls[controlname];
          const matching=formGroup.controls[matchingcontrolname];
          if(control.value !== matching.value){
           matching.setErrors({mustmatch:true}); 
          }
          else{
           matching.setErrors(null); 
          }
      }
   }
  
  submit(){
    let data ={
      userName:this.SignUp.controls['userName'].value,
      password:this.SignUp.controls['password'].value,
      role:this.SignUp.controls['role'].value,
      email:this.SignUp.controls['email'].value
    }
    localStorage.setItem('useremail', this.SignUp.controls['email'].value)
    this.ser.postuserdata(data).subscribe((res:any)=>{
      if(res.success == "data insert successfully"){
        this.router.navigateByUrl('/profile');
      }
    })
  }
}
