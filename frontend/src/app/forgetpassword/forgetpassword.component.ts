import { formatCurrency } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { NewserviceService } from '../newservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgetpassword',
  templateUrl: './forgetpassword.component.html',
  styleUrls: ['./forgetpassword.component.css']
})
export class ForgetpasswordComponent {
    mylogin: any;
    constructor(private fb: FormBuilder,private ser:NewserviceService,private router:Router){}
    ngOnInit(){
      this.mylogin=this.fb.group({
        email: ['',[Validators.required, Validators.email]],
        password:['',[Validators.required,Validators.minLength(8),Validators.maxLength(12),this.passwordvalidate]],
        repassword:['',[Validators.required,Validators.minLength(8),Validators.maxLength(12)]]
      },
      {
       validators:this.mustmatch('password','repassword')
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
       let data={
        email:this.mylogin.controls['email'].value,
        password:this.mylogin.controls['password'].value
       }
       console.log(data);
       this.ser.forgetpswd(data).subscribe((res:any)=>{
        console.log(res);
        if(res.success=="password updated"){
          alert("password updated");
          this.router.navigateByUrl('/login');
        }
        else{
          alert("please enter correct email id");
        }
       })
    }
    
}
