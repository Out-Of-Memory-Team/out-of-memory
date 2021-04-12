import { Observable } from 'rxjs';
import { tap } from "rxjs/operators";
import { User } from './../../shared/models/user.model';
import { SigninInfoDTO } from './../../shared/models/dto/SigninInfoDTO.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  login(signinInfo: SigninInfoDTO): Observable<any> {
    return (this.httpClient.post('http://localhost:8080/login', signinInfo)).pipe(tap(res => this.setSession(res)));
  }

  register(user: User): Observable<any> {
    return this.httpClient.post('http://localhost:8080/users', user);
  }

  private setSession(authResult) {
    localStorage.setItem('id_token', authResult.headers.get('Authorization'));
  }
}
