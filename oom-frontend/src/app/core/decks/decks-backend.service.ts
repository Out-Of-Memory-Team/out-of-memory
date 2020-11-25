import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {Deck} from "../../shared/models/deck.model";
import {Visibility} from "../../shared/models/visibility.model";
import {CardsBackendService} from "../cards/cards-backend.service";

@Injectable({
  providedIn: 'root'
})
export class DecksBackendService {

  private decks: Deck[] = [
    {
      deckId: '65c210c0-eb08-44c1-97ce-92d2a3d708c6',
      title: 'Software Engineering',
      description: 'RUP terms and stuff!',
      visibility: Visibility.PUBLIC,
      maintainer: null,
      collaborators: [],
      flashcards: [],
      tags: ['test', 'wololo', 'broccoli']
    },
    {
      deckId: '89abb3dc-91a5-4ad1-8647-516add00aae0',
      title: 'Rechnertechnik',
      description: null,
      visibility: Visibility.PUBLIC,
      maintainer: null,
      collaborators: [],
      flashcards: [],
      tags: ['test', 'wololo', 'broccoli']
    }
  ];

  constructor(private cardBackend: CardsBackendService) {}

  getDecks(): Observable<Deck[]> {
    return of(this.getPopulatedDecks());
  }

  getDeck(id: string): Observable<Deck> {
    return of(this.getPopulatedDecks().filter(deck => deck.deckId === id)[0]);
  }

  private getPopulatedDecks(): Deck[] {
    let res: Deck[] = []
    for(let deck of this.decks) {
      deck.flashcards = this.cardBackend.getCards();
      res.push(deck);
    }
    return res;
  }
}
