import {User} from "./user.model";
import {Flashcard} from "./flashcard.model";
import {Visibility} from "./visibility.model";
import {Tag} from "./tag.model";

export class Deck {

  deckId: string;
  title: string;
  description: string;
  visibility: Visibility;
  maintainer: User;
  collaborators: User[];
  flashcards: Flashcard[];
  tags: Tag[];
}
