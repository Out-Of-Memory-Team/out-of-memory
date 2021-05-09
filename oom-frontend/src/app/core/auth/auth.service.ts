import { Observable } from 'rxjs';
import { tap } from "rxjs/operators";
import { User } from './../../shared/models/user.model';
import { SigninInfoDTO } from './../../shared/models/dto/SigninInfoDTO.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse, HttpParams } from '@angular/common/http';
import {SignUpDTO} from "../../shared/models/dto/SignUpDTO.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly ENDPOINT = 'http://localhost:8080/';

  constructor(private httpClient: HttpClient) { }

  login(signinInfo: SigninInfoDTO): Observable<any> {
    let formData = new FormData()
    formData.append('username', signinInfo.username)
    formData.append('password', signinInfo.password);
    console.log(formData);
    return (this.httpClient.post(this.ENDPOINT + 'login', formData, { responseType: 'text', observe: 'response' })).pipe(tap(res => this.setSession(res)));
  }

  register(user: SignUpDTO): Observable<any> {
    return this.httpClient.put(this.ENDPOINT + 'users', user);
  }

  logout() {
    localStorage.removeItem('id_token');
  }

  private setSession(authResult) {
    localStorage.setItem('id_token', authResult.headers.get('Authorization'));
  }
}
