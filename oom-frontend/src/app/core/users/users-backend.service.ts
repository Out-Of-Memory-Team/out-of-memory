import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Flashcard} from "../../shared/models/flashcard.model";
import {User} from "../../shared/models/user.model";

@Injectable({
  providedIn: 'root'
})
export class UsersBackendService {

  private readonly ENDPOINT = '/api/users';

  constructor(private http: HttpClient) { }

  getUserByUsername(username: string): Observable<User> {
    return this.http.get<User>(this.ENDPOINT+"/name/"+username);
  }

  getUserByKeyword(keyword: string): Observable<string[][]> {
    return this.http.get<string[][]>(this.ENDPOINT+"/query/"+keyword);
  }
}
