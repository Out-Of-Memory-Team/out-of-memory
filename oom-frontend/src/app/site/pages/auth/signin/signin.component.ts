import { AuthService } from './../../../../core/auth/auth.service';
import {Component, OnInit} from '@angular/core';
import {SigninInfoDTO} from '../../../../shared/models/dto/SigninInfoDTO.model';

@Component({
  selector: 'page-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {

  constructor(private authService: AuthService) { }

  form = new SigninInfoDTO();

  ngOnInit(): void {
  }

  submit(): void {
    this.authService.login(this.form).subscribe(x => console.log(x));
  }

}
