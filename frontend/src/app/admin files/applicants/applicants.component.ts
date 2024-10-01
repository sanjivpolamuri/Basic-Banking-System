import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { NewserviceService } from 'src/app/newservice.service';

@Component({
  selector: 'app-applicants',
  templateUrl: './applicants.component.html',
  styleUrls: ['./applicants.component.css']
})
export class ApplicantsComponent {
  searchText: any;
  p=0;
  constructor(private ser:NewserviceService,private fb:FormBuilder){}
  rowdata:any;
  applicantstatus:any;
  ngOnInit(){
    this.applicantstatus=this.fb.group({    
      status: ['', Validators.required],
 
    })
    let data={
      email:localStorage.getItem('email')
    }
   
    this.ser.jobsapplied(data).subscribe((res:any)=>{
      this.rowdata=res;
    })
  }
  submit(a:any){
    let d={
      status:this.applicantstatus.controls['status'].value,
      applicationId:a
    }
    console.log(d.status);
    this.ser.applistatus(d).subscribe((res:any)=>{
      if(res.success=="status updated"){
        alert("status updated successfully");
      }
      else{
        alert("status is not updated");
      }
    })

  }
}
