import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../core/auth/auth.service";
import {User} from "../../../shared/models/user.model";
import {Observable} from "rxjs";

@Component({
  selector: 'layout-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  currentUser: User;

  constructor(public authService: AuthService) {
  }

  ngOnInit(): void {
    this.authService.currentUser.subscribe(user => this.currentUser = user);
  }

  logout(): void {
    this.authService.logout();
  }

}
