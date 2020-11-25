import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Deck} from "../../../../shared/models/deck.model";
import {ActivatedRoute} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {CardsBackendService} from "../../../../core/cards/cards-backend.service";
import {take} from "rxjs/operators";

@Component({
  selector: 'page-deck-editor',
  templateUrl: './deck-editor.component.html',
  styleUrls: ['./deck-editor.component.scss']
})
export class DeckEditorComponent implements OnInit {

  routeSub: Subscription;

  id: string;
  deck: Deck;

  constructor(private route: ActivatedRoute, private toastr: ToastrService, private deckBackend: DecksBackendService, private cardBackend: CardsBackendService) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.id = params['deck'];
      this.deckBackend.getDeck(this.id).pipe(take(1)).subscribe(d => this.deck = d);
    });
  }

  ngOnDestroy(): void {
    this.routeSub.unsubscribe();
  }
}
