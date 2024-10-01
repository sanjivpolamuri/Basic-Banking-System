import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NewserviceService } from 'src/app/newservice.service';
@Component({
  selector: 'app-jobsview',
  templateUrl: './jobsview.component.html',
  styleUrls: ['./jobsview.component.css']
})
export class JobsviewComponent {
searchText: any;
p=0;
constructor(private ser:NewserviceService, private router:Router){}
 rowdata:any
 ngOnInit(){
  this.ser.joblist().subscribe((res:any) =>{
    this.rowdata=res;
  })
 }
 submit(a:any){
  alert("Please conform it again");
  localStorage.setItem('jobId',this.rowdata[a-1].id);
  localStorage.setItem('companyId',this.rowdata[a-1].companyId);
  let data={
    email:localStorage.getItem('email'),
    status:"Applied",
    companyId:localStorage.getItem('companyId'),
    jobId:localStorage.getItem('jobId')
  }
  console.log(data);
  this.ser.postapplication(data).subscribe((res:any)=>{
    if(res.success=="applied for job"){
      alert("applied for job successfully");
    }
    else{
      alert("job is already added please check the Applied job list");
    }
  })
 }
}
