import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Flashcard} from "../../shared/models/flashcard.model";
import {User} from "../../shared/models/user.model";

@Injectable({
  providedIn: 'root'
})
export class UsersBackendService {

  private readonly ENDPOINT = 'http://localhost:8080/users';

  constructor(private http: HttpClient) { }

  getUserByUsername(username: string): Observable<User> {
    return this.http.get<User>(this.ENDPOINT+"/name/"+username);
  }

  getUserByKeyword(keyword: string): Observable<string[]> {
    return of([
      "test",
      "Test",
      "1234",
      "testuser",
      "testuser2"
    ]);//this.http.get<string[]>(this.ENDPOINT+"/query/"+keyword);
  }
}
