import { Component } from '@angular/core';
import { NewserviceService } from 'src/app/newservice.service';

@Component({
  selector: 'app-appliedjobs',
  templateUrl: './appliedjobs.component.html',
  styleUrls: ['./appliedjobs.component.css']
})
export class AppliedjobsComponent {
  searchText: any;
p=0;
constructor(private ser:NewserviceService, ){}
 rowdata:any
 values=['Applied','Rejected','Pending','Processing']
 ngOnInit(){
  
  let data={
    email:localStorage.getItem('email')
  }
  this.ser.appliedjobs(data).subscribe((res:any) =>{
    this.rowdata=res;
  })
 }
}
