import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Deck} from "../../../../shared/models/deck.model";
import {ActivatedRoute} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {CardsBackendService} from "../../../../core/cards/cards-backend.service";
import {take} from "rxjs/operators";
import {DialogType} from "../../../../core/dialog/dialog-data/dialog-type.enum";
import {DialogService} from "../../../../core/dialog/dialog.service";
import {Location} from "@angular/common";

@Component({
  selector: 'page-deck-editor',
  templateUrl: './deck-editor.component.html',
  styleUrls: ['./deck-editor.component.scss']
})
export class DeckEditorComponent implements OnInit {

  routeSub: Subscription;

  id: string;
  deck: Deck;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private toastr: ToastrService,
    public dialog: DialogService,
    private deckBackend: DecksBackendService,
    private cardBackend: CardsBackendService
  ) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.id = params['deck'];

      if(this.id === 'new') {
        this.deck = new Deck();
        return;
      }

      this.deckBackend.getDeck(this.id).pipe(take(1))
          .subscribe(
              d => this.deck = d,
              e => this.toastr.error('Deck could not be retrieved.', 'Failed!')
          );
    });
  }

  ngOnDestroy(): void {
    this.routeSub.unsubscribe();
  }

  saveChanges(): void {
    this.deckBackend.createOrUpdateDeck(this.deck).pipe(take(1))
      .subscribe(
        d => {
          this.toastr.success('Deck \''+d.title+'\' saved.', 'Success!');
          this.location.back();
        },
        e => this.toastr.error('Deck could not be saved.', 'Failed!')
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
