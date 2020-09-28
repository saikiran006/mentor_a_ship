import { createOfflineCompileUrlResolver, Identifiers } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../service/data.service';
@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  private emailId;
  public tasks;

  public updateId;
  public updateName;
  public update=false;
  public updatepercent=0;

  constructor(private service:DataService,
              private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.refreshTasks()
  }
  refreshTasks(){
    this.emailId=this.route.parent.snapshot.params['emailId']
      this.service.getTaskList(this.emailId).subscribe(
      res=>{this.tasks=res
        console.log(this.tasks)},
      err=>console.log(err)
    )
  console.log(this.emailId)
  }
  onUpdate(taskId,taskname){
  this.update=true;
  this.updateId=taskId;
  this.updateName=taskname;
  }
  onSubmit(){
    if(this.updatepercent<101){
      this.service.updateTaskPercent(this.updateId,this.updatepercent).subscribe()
      this.refreshTasks()
    }
  }

}
