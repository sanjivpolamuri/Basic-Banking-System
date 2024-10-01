import { Component } from '@angular/core';
import { NewserviceService } from 'src/app/newservice.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(public ser:NewserviceService ){}
names: any;
imageurl:any;
rowdata:any;
  ngOnInit(){
     this.names=localStorage.getItem('email');
     this.names=this.names.substring(0,this.names.indexOf('@'));
     let data={
      email:localStorage.getItem('email')
     }
     this.ser.imageretrive(data).subscribe((res:any)=>{
      console.log(res);
      this.rowdata=res;
      for(let a of this.rowdata){
        this.imageurl="data:image/jpeg;base64,"+a.image;
      }      
     })
  }
}

