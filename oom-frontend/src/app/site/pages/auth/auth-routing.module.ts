import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {SignupComponent} from './signup/signup.component';
import {SigninComponent} from './signin/signin.component';
import {UserDetailsComponent} from './user-details/user-details.component';

const routes: Routes = [
  { path: '', redirectTo: 'signin' },
  { path: 'signin', component: SigninComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'user', component: UserDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
