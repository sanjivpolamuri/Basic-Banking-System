import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin files/admin/admin.component';
import { ForgetpasswordComponent } from './forgetpassword/forgetpassword.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminhomeComponent } from './admin files/adminhome/adminhome.component';
import { UadminComponent } from './user files/uadmin/uadmin.component';
import { UserhomeComponent } from './user files/userhome/userhome.component';
import { JobsviewComponent } from './user files/jobsview/jobsview.component';
import { AddjobComponent } from './admin files/addjob/addjob.component';
import { AppliedjobsComponent } from './user files/appliedjobs/appliedjobs.component';
import { ApplicantsComponent } from './admin files/applicants/applicants.component';
import { ProfileupdateComponent } from './admin files/profileupdate/profileupdate.component';

const routes: Routes = [
  {
    path:'',component:HomeComponent
  },
  {
    path:'login',component:LoginComponent
  },
  {
    path:'signup',component:RegistrationComponent
  },
  {
    path:'admin', component:AdminComponent,
    children: [
      {
        path:'home',component:AdminhomeComponent
      },
      {
        path:'addjob',component:AddjobComponent
      },
      {
        path:'applicants',component:ApplicantsComponent
      },
      {
        path:'profileupdate',component:ProfileupdateComponent
      }
    ]
  },
  {
    path:'user', component:UadminComponent,
    children:[
      {
        path:'home',component:UserhomeComponent
      },
      {
        path:'jobs',component:JobsviewComponent
      },
      {
        path:'appliedjobs',component:AppliedjobsComponent
      },
      {
        path:'profileupdate',component:ProfileupdateComponent
      }
    ]
  },
  {
    path:'forgetpassword', component:ForgetpasswordComponent
  },
  {
    path:'profile', component:ProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
