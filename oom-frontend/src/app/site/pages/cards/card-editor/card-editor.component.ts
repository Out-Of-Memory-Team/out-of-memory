import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {take} from "rxjs/operators";
import {Flashcard} from "../../../../shared/models/flashcard.model";
import {CardsBackendService} from "../../../../core/cards/cards-backend.service";
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {Deck} from "../../../../shared/models/deck.model";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'page-card-editor',
  templateUrl: './card-editor.component.html',
  styleUrls: ['./card-editor.component.scss']
})
export class CardEditorComponent implements OnInit, OnDestroy {

  modules = {
    toolbar: [
      ['bold', 'italic', 'underline', 'strike'],

      [{ 'size': ['small', false, 'large'] }],
      [{ 'color': [] }, { 'background': [] }],

      [{ 'script': 'sub'}, { 'script': 'super' }],

      [{ 'list': 'ordered'}, { 'list': 'bullet' }],
      ['blockquote', 'code-block'],

      ['link', 'image']
    ]
  };
  items: string[] = ['Item1', 'Item2', 'Item3'];
  vertical = '';

  routeSub: Subscription;

  id: string;
  card: Flashcard;
  decks: Deck[];

  constructor(
    private route: ActivatedRoute,
    private toastr: ToastrService,
    public cardBackend: CardsBackendService,
    public deckBackend: DecksBackendService
  ) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.id = params['card'];
      this.cardBackend.getCard(this.id).pipe(take(1))
        .subscribe(
          c => this.card = c,
          e => this.toastr.error("Card could not be retrieved.", "Failed!")
        );
    });
    this.deckBackend.getDecks().pipe(take(1))
      .subscribe(
        c => this.decks = c,
        e => this.toastr.error("Decks could not be retrieved.", "Failed!")
      );
  }

  ngOnDestroy(): void {
    this.routeSub.unsubscribe();
  }
}
