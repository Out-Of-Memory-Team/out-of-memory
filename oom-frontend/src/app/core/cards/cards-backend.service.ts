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

  updateCard(newCard: Flashcard): boolean {
    return false;
  }

  deleteCard(id: string): boolean {
    return false;
  }
}
