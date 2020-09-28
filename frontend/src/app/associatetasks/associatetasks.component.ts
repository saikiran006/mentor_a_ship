import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { DataService } from '../service/data.service';
import {Task} from './../models/task' 
@Component({
  selector: 'app-associatetasks',
  templateUrl: './associatetasks.component.html',
  styleUrls: ['./associatetasks.component.css']
})
export class AssociatetasksComponent implements OnInit {
  public id:number;
  public tasks;
  public newtask;
  public add=false;

  public taskname="NAME";
  public taskdate;
  public taskpercent=0;
  public taskassesment="ASSESSMENT";
  public tasknotes="NOTES";
  public nameIsNull=false;

  constructor(private route:ActivatedRoute,
              private service: DataService,
              private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id']
  this.refreshTasks() 
  }
  refreshTasks(){
    this.service.getTaskList(this.id).subscribe(
      res=>this.tasks=res,
      err=>console.log(err)
    )
    }
    onAddTask(){
      if(this.taskname=="NAME"){
        this.nameIsNull=true;
        return
      }
      this.nameIsNull=false
     this.newtask=new Task(this.taskname,0,this.taskassesment,this.tasknotes,this.taskdate);
      this.service.addNewTask(this.id,this.newtask).subscribe(
        res=>{console.log(res)
          this.refreshTasks()},
        err=>console.log(err)
      )
      
    }
    onDelete(taskId){
      this.service.deleteTask(taskId).subscribe(
        res=>{console.log(res)
          this.refreshTasks()},
        err=>console.log(err)
      )
      
    }

}
