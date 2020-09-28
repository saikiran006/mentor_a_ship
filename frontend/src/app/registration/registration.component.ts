import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  isAssociate:boolean;
  form: FormGroup;
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
    this.form = this.formBuilder.group({
      usertype:['',Validators.required],
       emailId: ['',[ Validators.required,Validators.email]],
       mentorEmailId:['',Validators.email],
       name:['',Validators.required],
      password: ['', [Validators.required,Validators.pattern('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$')]],
      organization:[''],
      role:[''],
      areaOfInterest:[''],
      expertise:[''],
      image:['']
  })
  }
  setMentor(){
    this.isAssociate=false;
  }
  setAssociate(){
    this.isAssociate=true;
  }
  onFileChange(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.form.get('image').setValue(file);
    }
  }
  get f() { return this.form.controls; }
  onSubmit() {
    this.submitted=true;
    if (this.form.invalid) {
      return;
  }
  const formData = new FormData();
   if(!this.isAssociate){
    formData.append('name', this.form.get('name').value);
    formData.append('emailId', this.form.get('emailId').value);
    formData.append('password', this.form.get('password').value);
    formData.append('organization', this.form.get('organization').value);
    formData.append('role', this.form.get('role').value);
    formData.append('expertise', this.form.get('expertise').value);
    formData.append('areaOfInterest', this.form.get('areaOfInterest').value);
    formData.append('image', this.form.get('image').value);
    this.http.post('http://localhost:8080/mentor',formData).subscribe(
      res=>{console.log(res),
            this.error='Mentor Succesfully Registeres'},
      err=>{this.error=err.error.message; 
      console.log(err.erro)}
    )
   }
   else{
    formData.append('name', this.form.get('name').value);
    formData.append('emailId', this.form.get('emailId').value);
    formData.append('mentorEmailId', this.form.get('mentorEmailId').value);
    
    formData.append('password', this.form.get('password').value);
    formData.append('image', this.form.get('image').value);
    this.http.post('http://localhost:8080/associate',formData).subscribe(
      res=>{console.log(res)
        this.error='Associate Succesfully Registered'},
      err=>{this.error=err.error.message;
        console.log(err)}
    )
   }
    }


}
