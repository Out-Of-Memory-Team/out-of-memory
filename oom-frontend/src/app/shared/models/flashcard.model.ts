import {Deck} from "./deck.model";

export class Flashcard {

  constructor() {
    this.cardId = null;
  }

  cardId?: string;
  deckId?: string;
  front: string;
  back: string;
}
