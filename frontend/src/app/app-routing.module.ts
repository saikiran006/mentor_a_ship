import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdashboardComponent } from './adashboard/adashboard.component';
import { AdminmenuComponent } from './adminmenu/adminmenu.component';
import { AprofileComponent } from './aprofile/aprofile.component';
import { AssociateListComponent } from './associate-list/associate-list.component';
import { AssociatemenuComponent } from './associatemenu/associatemenu.component';
import { AssociatetasksComponent } from './associatetasks/associatetasks.component';
import { LoginComponent } from './login/login.component';
import { MentordashboardComponent } from './mentordashboard/mentordashboard.component';
import { MentormenuComponent } from './mentormenu/mentormenu.component';
import { MentorprofileComponent } from './mentorprofile/mentorprofile.component';
import { RegistrationComponent } from './registration/registration.component';
import { TaskListComponent } from './task-list/task-list.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'register', component:RegistrationComponent},
  {path:'adash/:emailId',component:AdashboardComponent,
children : [
              { path: 'aprofile', component: AprofileComponent },
              { path: 'tasks', component: TaskListComponent },
              { path: 'logout', component: LoginComponent }
           ]
      },
  {path:'amenu/',component:AssociatemenuComponent },
  {path:'mmenu',component:MentormenuComponent},
  {path:'mdash/:emailId',component:MentordashboardComponent,
    children:[
              {path:'mprofile',component:MentorprofileComponent},
              {path:'associates',component:AssociateListComponent},
              {path:'associates/atasks/:id',component:AssociatetasksComponent},
              
              {path:'logout',component:LoginComponent},
    ]},
  {path:'adminmenu/:emailId',component:AdminmenuComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
