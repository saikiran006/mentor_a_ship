import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Associate } from '../models/associate';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-associate-list',
  templateUrl: './associate-list.component.html',
  styleUrls: ['./associate-list.component.css']
})
export class AssociateListComponent implements OnInit {
 private emailId;
 public associates:Associate[];
  constructor(private route:ActivatedRoute,private Service:DataService) { }

  ngOnInit(): void {
    this.emailId=this.route.parent.snapshot.params['emailId'];
    this.refreshAssociateList()
  }
  refreshAssociateList(){
    this.Service.getAssociateList(this.emailId).subscribe(
      res=>{this.associates=res
            console.log(this.associates)},
      err=>console.log(err)
    )
  }
}
