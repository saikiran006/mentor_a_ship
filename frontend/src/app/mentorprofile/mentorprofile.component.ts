import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { resourceUsage } from 'process';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-mentorprofile',
  templateUrl: './mentorprofile.component.html',
  styleUrls: ['./mentorprofile.component.css']
})
export class MentorprofileComponent implements OnInit {
public profile;
private emailId:string;
  constructor(private service:DataService,private route:ActivatedRoute) { }

  ngOnInit(): void {
      this.emailId=this.route.parent.snapshot.params['emailId']
      this.refreshProfile()
  }
  refreshProfile(){
    this.service.getMentorProfile(this.emailId).subscribe(
      res=>{this.profile=res
              console.log(res)},
      err=>console.log(err)
    )
  }

}
