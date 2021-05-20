import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../../core/auth/auth.service";
import {SigninInfoDTO} from "../../../../shared/models/dto/SigninInfoDTO.model";
import {User} from "../../../../shared/models/user.model";
import {SignUpDTO} from "../../../../shared/models/dto/SignUpDTO.model";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'page-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor(private authService: AuthService,
              private router: Router,
              private toastr: ToastrService
  ) { }

  form = new SignUpDTO();
  registerFail: boolean = false;

  ngOnInit(): void {
  }

  submit(): void {
    this.authService.register(this.form).subscribe(res => {
        this.toastr.success('Registration successfull.', 'Success!')
        this.router.navigate(['auth/signin']);
      },
      err => {
        this.form.email = "";
        this.form.password = "";
        this.form.username = "";
        this.registerFail = true;
      });
  }
}
