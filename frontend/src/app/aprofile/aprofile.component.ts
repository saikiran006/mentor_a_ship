import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {DataService} from './../service/data.service'
@Component({
  selector: 'app-aprofile',
  templateUrl: './aprofile.component.html',
  styleUrls: ['./aprofile.component.css']
})


export class AprofileComponent implements OnInit {
 emailId:string;
 profile;
  constructor(
    private route: ActivatedRoute,
    private service: DataService,
  ) { }

  ngOnInit(): void {
    this.emailId=this.route.parent.snapshot.params['emailId']
    this.service.getAssociateProfile(this.emailId).subscribe(
      res=>{this.profile=res
            console.log(this.profile)},
      err=>console.log(err)
    )
  }

}
