import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-associatemenu',
  templateUrl: './associatemenu.component.html',
  styleUrls: ['./associatemenu.component.css']
})
export class AssociatemenuComponent implements OnInit {
 emailId:String
  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.emailId = this.route.snapshot.params['emailId'];
    console.log(this.emailId)
  }

}
