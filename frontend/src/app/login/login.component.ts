import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error:any;
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private http:HttpClient
  ) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
            usertype:['',Validators.required],
             emailId: ['', Validators.required],
            password: ['', Validators.required]
        })
  }
  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted=true;
    if (this.loginForm.invalid) {
      return;
  }
   if(this.f.usertype.value=="Associate"){
     console.log(this.f)
      this.http.get<any>(`http://localhost:8080/associate/${this.f.emailId.value}`).subscribe(
        res=>{if(res.emailId==this.f.emailId.value&&res.password==this.f.password.value){
          this.router.navigate(['adash',this.f.emailId.value])
        }
        else{
          this.error="Wrong Credentials"
        }
      },
        err=>{this.error=err.error.message;
          console.log(err)}
      )
   }
   if(this.f.usertype.value=="Mentor"){
    console.log(this.f)
     this.http.get<any>(`http://localhost:8080/mentor/${this.f.emailId.value}`).subscribe(
       res=>{if(res.emailId==this.f.emailId.value&&res.password==this.f.password.value){
         this.router.navigate(['mdash',this.f.emailId.value])
        }
        else{
          this.error="Wrong Credentials"
        }
       },
       err=>{this.error=err.error.message;
         console.log(err)}
     )
  }
  if(this.f.usertype.value=="Admin"){
    console.log(this.f)
     this.http.get<any>(`http://localhost:8080/admin/${this.f.emailId.value}`).subscribe(
       res=>{console.log(res), 
         this.router.navigate(['adminmenu',this.f.emailId.value])},
       err=>{this.error=err.error.message;
         console.log(err)}
     )
  }
    }
}
