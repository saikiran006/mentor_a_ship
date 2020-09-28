import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ITS_JUST_ANGULAR } from '@angular/core/src/r3_symbols';
import { Associate } from '../models/associate';
import { Mentor } from '../models/mentor';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient) { }

  getAssociateProfile(emailId){
    return this.http.get<any>(`http://localhost:8080/associate/${emailId}`)
  }

  getTaskList(emailId){
    return this.http.get<any>(`http://localhost:8080/tasks/${emailId}`)
  }
  updateTaskPercent(Id,percent){
    console.log(Id,percent)
     return this.http.post(`http://localhost:8080/task/${Id}`,percent)
  }
  getMentorProfile(emailId){
    return this.http.get<Mentor>(`http://localhost:8080/mentor/${emailId}`)
  }
  getAssociateList(emailId){
    return this.http.get<Associate[]>(`http://localhost:8080/m/associates/${emailId}`)
  }
  deleteTask(taskId){
    return this.http.delete(`http://localhost:8080/task/${taskId}`)
  }

  addNewTask(emailId,task)
  {
   return this.http.post(`http://localhost:8080/task/add/${emailId}`,task)
  }
}
