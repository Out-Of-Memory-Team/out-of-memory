import {BehaviorSubject, Observable, of} from 'rxjs';
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

  private readonly ENDPOINT = '/api/';

  private currentUserSource: BehaviorSubject<User> = new BehaviorSubject<User>(null);
  currentUser = this.currentUserSource.asObservable();

  constructor(private httpClient: HttpClient) { }

  login(signinInfo: SigninInfoDTO): Observable<any> {
    let formData = new FormData()
    formData.append('username', signinInfo.username)
    formData.append('password', signinInfo.password);
    return (this.httpClient.post(this.ENDPOINT + 'login', formData, { responseType: 'text', observe: 'response' })).pipe(tap(res => this.setSession(res)));
  }

  register(user: SignUpDTO): Observable<any> {
    return this.httpClient.put(this.ENDPOINT + 'users', user);
  }

  logout() {
    localStorage.removeItem('id_token');
    this.checkForLogin();
  }

  private setSession(authResult) {
    localStorage.setItem('id_token', authResult.headers.get('Authorization'));
    this.checkForLogin();
  }

  checkForLogin() {
    this.httpClient.get<User>(this.ENDPOINT + 'user').subscribe(user => this.currentUserSource.next(user), error => this.currentUserSource.next(null));
  }
}
