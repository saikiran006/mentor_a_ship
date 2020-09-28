import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import { HttpClientModule } from '@angular/common/http';
import { AssociatemenuComponent } from './associatemenu/associatemenu.component';
import { MentormenuComponent } from './mentormenu/mentormenu.component';
import { AdminmenuComponent } from './adminmenu/adminmenu.component';
import { TaskListComponent } from './task-list/task-list.component';
import { AdashboardComponent } from './adashboard/adashboard.component';
import { AprofileComponent } from './aprofile/aprofile.component';
import { MentordashboardComponent } from './mentordashboard/mentordashboard.component';
import { MentorprofileComponent } from './mentorprofile/mentorprofile.component';
import { AssociateListComponent } from './associate-list/associate-list.component';
import { AssociatetasksComponent } from './associatetasks/associatetasks.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    AssociatemenuComponent,
    MentormenuComponent,
    AdminmenuComponent,
    TaskListComponent,
    AdashboardComponent,
    AprofileComponent,
    MentordashboardComponent,
    MentorprofileComponent,
    AssociateListComponent,
    AssociatetasksComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
