import { AuthService } from './../../../../core/auth/auth.service';
import {Component, OnInit} from '@angular/core';
import {SigninInfoDTO} from '../../../../shared/models/dto/SigninInfoDTO.model';
import {Router} from "@angular/router";

@Component({
  selector: 'page-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  form = new SigninInfoDTO();
  loginFail = false;

  ngOnInit(): void {
  }

  submit(): void {
    this.authService.login(this.form).subscribe(res => {
        this.loginFail = false;
        this.router.navigate(['']);
      },
      x => {
        this.form = new SigninInfoDTO();
        this.loginFail = true;
      });
  }
}
