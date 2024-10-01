import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { NgOptimizedImage } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MainComponent } from './admin files/main/main.component';
import { HeaderComponent } from './admin files/header/header.component';
import { NavbarComponent } from './admin files/navbar/navbar.component';
import { AdminComponent } from './admin files/admin/admin.component';
import { ForgetpasswordComponent } from './forgetpassword/forgetpassword.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminhomeComponent } from './admin files/adminhome/adminhome.component';
import { UadminComponent } from './user files/uadmin/uadmin.component';
import { UheaderComponent } from './user files/uheader/uheader.component';
import { UmainComponent } from './user files/umain/umain.component';
import { UnavibarComponent } from './user files/unavibar/unavibar.component';
import { UserhomeComponent } from './user files/userhome/userhome.component';
import { JobsviewComponent } from './user files/jobsview/jobsview.component';
import { AddjobComponent } from './admin files/addjob/addjob.component';
import { SearchPipe } from './search.pipe';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppliedjobsComponent } from './user files/appliedjobs/appliedjobs.component';
import { ApplicantsComponent } from './admin files/applicants/applicants.component';
import { ProfileupdateComponent } from './admin files/profileupdate/profileupdate.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    AdminComponent,
    ForgetpasswordComponent,
    ProfileComponent,
    MainComponent,
    HeaderComponent,
    NavbarComponent,
    AdminhomeComponent,
    UadminComponent,
    UheaderComponent,
    UmainComponent,
    UnavibarComponent,
    UserhomeComponent,
    JobsviewComponent,
    AddjobComponent,
    SearchPipe,
    AppliedjobsComponent,
    ApplicantsComponent,
    ProfileupdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CardModule,
    ButtonModule,
    NgOptimizedImage,
    InputTextModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
