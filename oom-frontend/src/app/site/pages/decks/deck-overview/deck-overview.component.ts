import {Component, OnInit} from '@angular/core';
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {Deck} from "../../../../shared/models/deck.model";
import {take} from "rxjs/operators";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'page-deck-overview',
  templateUrl: './deck-overview.component.html',
  styleUrls: ['./deck-overview.component.scss']
})
export class DeckOverviewComponent implements OnInit {

  decks: Deck[];

  constructor(private toastr: ToastrService, public deckBackend: DecksBackendService) { }

  ngOnInit(): void {
    this.deckBackend.getDecks().pipe(take(1))
      .subscribe(
        decks => this.decks = decks,
        e => this.toastr.error("Deck could not be retrieved.", "Failed!")
      );
  }
}
