import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {Deck} from "../../shared/models/deck.model";
import {Visibility} from "../../shared/models/visibility.model";

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
      flashcards: [
        {
          cardId: '513a68ed-fb69-4bed-9da5-52cdfc7445f5',
          front: 'Front 1 Test Content 123',
          back: 'Back 1 Test Content 123'
        },
        {
          cardId: '0fdc6730-acd9-4113-8d9f-7b1d54a19c8a',
          front: 'Front 2 Test Content 123',
          back: 'Back 2 Test Content 123'
        },
        {
          cardId: 'a16934d6-5db6-46c0-8114-115b5cee14f0',
          front: 'Front 3 Test Content 123',
          back: 'Back 3 Test Content 123'
        },
        {
          cardId: 'd56c6d14-e779-4ffe-ae4f-918a949e7738',
          front: 'Front 4 Test Content 123',
          back: 'Back 4 Test Content 123'
        }
      ],
      tags: ['test', 'wololo', 'broccoli']
    },
    {
      deckId: '89abb3dc-91a5-4ad1-8647-516add00aae0',
      title: 'Rechnertechnik',
      description: null,
      visibility: Visibility.PUBLIC,
      maintainer: null,
      collaborators: [],
      flashcards: [
        {
          cardId: '513a68ed-fb69-4bed-9da5-52cdfc7445f5',
          front: 'Front 1 Test Content 123',
          back: 'Back 1 Test Content 123'
        },
        {
          cardId: '0fdc6730-acd9-4113-8d9f-7b1d54a19c8a',
          front: 'Front 2 Test Content 123',
          back: 'Back 2 Test Content 123'
        },
        {
          cardId: 'a16934d6-5db6-46c0-8114-115b5cee14f0',
          front: 'Front 3 Test Content 123',
          back: 'Back 3 Test Content 123'
        },
        {
          cardId: 'd56c6d14-e779-4ffe-ae4f-918a949e7738',
          front: 'Front 4 Test Content 123',
          back: 'Back 4 Test Content 123'
        }
      ],
      tags: ['test', 'wololo', 'broccoli']
    }
  ];

  constructor() { }

  getDecks(): Observable<Deck[]> {
    return of(this.decks);
  }

  getDeck(id: string): Observable<Deck> {
    return of(this.decks[0]);
  }
}
