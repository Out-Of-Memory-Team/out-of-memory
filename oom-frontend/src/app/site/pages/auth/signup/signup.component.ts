import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../../core/auth/auth.service";
import {SigninInfoDTO} from "../../../../shared/models/dto/SigninInfoDTO.model";
import {User} from "../../../../shared/models/user.model";
import {SignUpDTO} from "../../../../shared/models/dto/SignUpDTO.model";

@Component({
  selector: 'page-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor(private authService: AuthService) { }

  form = new SignUpDTO();

  ngOnInit(): void {
  }

  submit(): void {
    this.authService.register(this.form).subscribe(x => console.log(x));
  }
}
