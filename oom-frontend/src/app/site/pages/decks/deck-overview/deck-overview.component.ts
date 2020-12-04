import {Component, OnInit} from '@angular/core';
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {Deck} from "../../../../shared/models/deck.model";
import {take} from "rxjs/operators";

@Component({
  selector: 'page-deck-overview',
  templateUrl: './deck-overview.component.html',
  styleUrls: ['./deck-overview.component.scss']
})
export class DeckOverviewComponent implements OnInit {

  decks: Deck[];

  constructor(public deckBackend: DecksBackendService) { }

  ngOnInit(): void {
    this.deckBackend.getDecks().pipe(take(1)).subscribe(decks => this.decks = decks);
  }
}
