import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {Deck} from "../../shared/models/deck.model";
import {Visibility} from "../../shared/models/visibility.model";
import {CardsBackendService} from "../cards/cards-backend.service";
import {HttpClient} from "@angular/common/http";
import {take} from "rxjs/operators";
import {Flashcard} from "../../shared/models/flashcard.model";

@Injectable({
  providedIn: 'root'
})
export class DecksBackendService {

  private readonly ENDPOINT = '/api/decks';

  constructor(private http: HttpClient) {}

  getDecks(): Observable<Deck[]> {
    return this.http.get<Deck[]>(this.ENDPOINT);
  }

  getDeck(id: string): Observable<Deck> {
    return this.http.get<Deck>(this.ENDPOINT+"/"+id);
  }

  createOrUpdateDeck(newDeck: Deck): Observable<Deck> {
    return this.http.put<Deck>(this.ENDPOINT, newDeck);
  }

  deleteDeck(id: string): Observable<Deck> {
    return this.http.delete<Deck>(this.ENDPOINT+"/"+id);
  }
}
