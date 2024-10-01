import { Component } from '@angular/core';
import { NewserviceService } from 'src/app/newservice.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent {
  rowdata: any;
  constructor(private ser:NewserviceService){}
   ngOnInit(){
    var d=localStorage.getItem('email');
     let data={
      email:d
     }
     this.ser.profiledata(data).subscribe((res:any)=>{
      this.rowdata=res;
     })
   }
}
