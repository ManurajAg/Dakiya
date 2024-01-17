import { Component } from '@angular/core';
import { EmailService } from '../../service/email.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrl: './email.component.css'
})
export class EmailComponent {
  data = {
    to:"",
    subject:"",
    message:""
  }
  flag= false;
  constructor(private email:EmailService,private snack:MatSnackBar){}
  doSubmitForm(){

    if(this.data.to == ""||this.data.subject==""||this.data.message==""){
      this.snack.open("Fields Cannot be empty","Ok");
      return;
    }
    this.flag = true;
    this.email.sendEmail(this.data).subscribe(
      response=>{
        this.snack.open("Email Sent","OK");
        this.flag = false;
      },
      error=>{
        this.snack.open("Something Went Wrong","OK");
        this.flag = false;
      }
    );
  }
}
