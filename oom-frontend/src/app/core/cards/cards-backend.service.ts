import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {Flashcard} from "../../shared/models/flashcard.model";

@Injectable({
  providedIn: 'root'
})
export class CardsBackendService {

  private flashcards = [
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
  ];

  constructor() { }

  getCard(id: string): Observable<Flashcard> {
    return of(this.flashcards[0]);
  }

  getCards(): Flashcard[] {
    return this.flashcards;
  }

  updateCard(newCard: Flashcard): boolean {
    let index = this.flashcards.findIndex(card => card.cardId === newCard.cardId);
    if (index > -1) {
      this.flashcards[index] = newCard;
      return true;
    }
    return false;
  }

  deleteCard(id: string): boolean {
    let index = this.flashcards.findIndex(card => card.cardId === id);
    if (index > -1) {
      this.flashcards.splice(index, 1);
      return true;
    }
    return false;
  }
}
