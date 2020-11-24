import {Component, OnInit} from '@angular/core';
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";

@Component({
  selector: 'page-deck-overview',
  templateUrl: './deck-overview.component.html',
  styleUrls: ['./deck-overview.component.scss']
})
export class DeckOverviewComponent implements OnInit {

  constructor(public deckBackend: DecksBackendService) { }

  ngOnInit(): void {
  }

}
