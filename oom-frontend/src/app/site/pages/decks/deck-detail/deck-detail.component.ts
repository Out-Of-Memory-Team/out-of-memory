import {Component, OnDestroy, OnInit} from '@angular/core';
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {Deck} from "../../../../shared/models/deck.model";
import {ActivatedRoute} from "@angular/router";
import {take} from "rxjs/operators";
import {Subscription} from "rxjs";
import {CardsBackendService} from "../../../../core/cards/cards-backend.service";
import {ToastrService} from "ngx-toastr";
import {DialogService} from "../../../../core/dialog/dialog.service";
import {DialogType} from "../../../../core/dialog/dialog-data/dialog-type.enum";

@Component({
  selector: 'page-deck-detail',
  templateUrl: './deck-detail.component.html',
  styleUrls: ['./deck-detail.component.scss']
})
export class DeckDetailComponent implements OnInit, OnDestroy {

  routeSub: Subscription;

  id: string;
  deck: Deck;

  constructor(
    private route: ActivatedRoute,
    private toastr: ToastrService,
    public dialog: DialogService,
    private deckBackend: DecksBackendService,
    private cardBackend: CardsBackendService
  ) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.id = params['deck'];
      this.deckBackend.getDeck(this.id).pipe(take(1)).subscribe(d => this.deck = d);
    });
  }

  ngOnDestroy(): void {
    this.routeSub.unsubscribe();
  }

  deleteCard(id: string): void {
    const res = this.dialog.open({
      data: {
        type: DialogType.WARNING,
        title: 'Delete Flashcard',
        message: 'Are you sure about deleting the flashcard?',
        submitMessage: 'Delete'
      },
    });

    res.afterClosed.pipe(take(1)).subscribe(cause => {
      if(cause !== 'submit')
        return;

      if(this.cardBackend.deleteCard(id)) {
        this.toastr.success("Flashcard deleted.", "Success!")
      } else {
        this.toastr.error("Flashcard could not be deleted.", "Failed!")
      }
    });
  }
}
