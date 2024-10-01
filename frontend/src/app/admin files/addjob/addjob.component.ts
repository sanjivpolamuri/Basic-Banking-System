import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { NewserviceService } from 'src/app/newservice.service';

@Component({
  selector: 'app-addjob',
  templateUrl: './addjob.component.html',
  styleUrls: ['./addjob.component.css']
})
export class AddjobComponent {
  public sampleform:any
  public data:any
  constructor(private formbuilder:FormBuilder,private ser:NewserviceService, private _sanitizer: DomSanitizer)
  {
    this.sampleform = this.formbuilder.group({
      title: ['', Validators.required, Validators.maxLength(15)],
      jobType: ['', Validators.required,Validators.maxLength(5)],
      companyId: ['', [Validators.required, Validators.pattern('[0-9]{10}')]],
      location: ['', [Validators.required, Validators.email]],
      salary: ['', Validators.required],
      companyName: ['', Validators.required],
      jobSkills: ['', Validators.required],
    });
  }
  onSubmit()
  {
     this.data ={
      title :this.sampleform.controls['title'].value,
      jobType :this.sampleform.controls['jobType'].value,
      companyId :this.sampleform.controls['companyId'].value,
      location :this.sampleform.controls['location'].value,
      salary :this.sampleform.controls['salary'].value,
      companyName :this.sampleform.controls['companyName'].value,
      jobSkills :this.sampleform.controls['jobSkills'].value,
      email:localStorage.getItem('email')
    }
   this.ser.postjob(this.data).subscribe((res:any)=>{
    if(res.success=="job added"){
      alert("job added successfully");
    }
    else{
      alert("job is not added");
    }
    this.sampleform.reset();
   })
  }
}
