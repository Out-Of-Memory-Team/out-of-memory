import {Deck} from "./deck.model";

export class Flashcard {

  constructor() {
    this.cardId = null;
    this.index = -1;
  }

  cardId?: string;
  deckId?: string;
  front: string;
  back: string;
  index: number;
}
