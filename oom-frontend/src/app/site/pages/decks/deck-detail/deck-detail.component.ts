import {Component, OnDestroy, OnInit} from '@angular/core';
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {Deck} from "../../../../shared/models/deck.model";
import {ActivatedRoute} from "@angular/router";
import {take} from "rxjs/operators";
import {Subscription} from "rxjs";

@Component({
  selector: 'page-deck-detail',
  templateUrl: './deck-detail.component.html',
  styleUrls: ['./deck-detail.component.scss']
})
export class DeckDetailComponent implements OnInit, OnDestroy {

  routeSub: Subscription;

  id: string;
  deck: Deck;

  constructor(private route: ActivatedRoute, public deckBackend: DecksBackendService) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.id = params['id'];
      this.deckBackend.getDeck(this.id).pipe(take(1)).subscribe(d => this.deck = d);
    });
  }

  ngOnDestroy(): void {
    this.routeSub.unsubscribe();
  }
}
