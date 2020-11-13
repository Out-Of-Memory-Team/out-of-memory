import {Component, OnInit} from '@angular/core';
import {SigninInfoDTO} from '../../../../shared/models/dto/SigninInfoDTO.model';

@Component({
  selector: 'page-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {

  constructor() { }

  form = new SigninInfoDTO();

  ngOnInit(): void {
  }

}
