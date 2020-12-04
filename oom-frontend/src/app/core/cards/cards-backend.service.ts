import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {Flashcard} from "../../shared/models/flashcard.model";
import {Deck} from "../../shared/models/deck.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CardsBackendService {

  private readonly ENDPOINT = '/api/cards';

  constructor(private http: HttpClient) { }

  getCard(id: string): Observable<Flashcard> {
    return this.http.get<Flashcard>(this.ENDPOINT+"/"+id);
  }

  addCard(newCard: Flashcard): Observable<Flashcard> {
    return this.http.post<Flashcard>(this.ENDPOINT, newCard);
  }

  updateCard(id: string, newCard: Flashcard): Observable<Flashcard> {
    return this.http.put<Flashcard>(this.ENDPOINT+"/"+id, newCard);
  }

  deleteCard(id: string): Observable<Flashcard> {
    return this.http.delete<Flashcard>(this.ENDPOINT+"/"+id);
  }
}
