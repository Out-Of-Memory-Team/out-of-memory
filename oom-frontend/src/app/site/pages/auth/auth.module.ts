import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AuthRoutingModule} from './auth-routing.module';
import {SignupComponent} from './signup/signup.component';
import {SigninComponent} from './signin/signin.component';
import {ClrInputModule, ClrPasswordModule} from '@clr/angular';
import {FormsModule} from '@angular/forms';
import {UserDetailsComponent} from './user-details/user-details.component';


@NgModule({
  declarations: [SignupComponent, SigninComponent, UserDetailsComponent],
  imports: [
    CommonModule,
    AuthRoutingModule,
    FormsModule,
    ClrPasswordModule,
    ClrInputModule
  ]
})
export class AuthModule { }
