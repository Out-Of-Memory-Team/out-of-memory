import {Component, OnDestroy, OnInit} from '@angular/core';
import {Location} from '@angular/common'
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {take} from "rxjs/operators";
import {Flashcard} from "../../../../shared/models/flashcard.model";
import {CardsBackendService} from "../../../../core/cards/cards-backend.service";
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {Deck} from "../../../../shared/models/deck.model";
import {ToastrService} from "ngx-toastr";
import {DialogType} from "../../../../core/dialog/dialog-data/dialog-type.enum";
import {DialogService} from "../../../../core/dialog/dialog.service";

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
    private location: Location,
    private toastr: ToastrService,
    public dialog: DialogService,
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

  saveChanges(): void {
    if(this.id === 'new') {
      this.deckBackend.getDecks().pipe(take(1))
        .subscribe(
          c => {
            this.toastr.success("Card saved.", "Success!");
            this.location.back();
          },
          e => this.toastr.error("Card could not be saved.", "Failed!")
        );
    }

    this.cardBackend.updateCard(this.id, this.card).pipe(take(1))
      .subscribe(
        c => {
          this.toastr.success("Card saved.", "Success!");
          this.location.back();
        },
        e => this.toastr.error("Card could not be saved.", "Failed!")
      );
  }

  discardChanges(): void {
    const res = this.dialog.open({
      data: {
        type: DialogType.WARNING,
        title: 'Discard Changes',
        message: 'Are you sure you want to discard all changes?',
        submitMessage: 'Discard'
      },
    });

    res.afterClosed.pipe(take(1)).subscribe(cause => {
      if(cause !== 'submit')
        return;

      this.location.back()
    });
  }
}
