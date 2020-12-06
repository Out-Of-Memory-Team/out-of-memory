import {User} from "./user.model";
import {Flashcard} from "./flashcard.model";
import {Visibility} from "./visibility.model";
import {Tag} from "./tag.model";

export class Deck {

  constructor() {
    this.deckId = null;
    this.visibility = Visibility.PUBLIC;
    this.collaborators = [];
    this.flashcards = [];
    this.tags = [];
  }

  deckId: string;
  title: string;
  description: string;
  visibility: Visibility;
  maintainer: User;
  collaborators: User[];
  flashcards: Flashcard[];
  tags: Tag[];
}
