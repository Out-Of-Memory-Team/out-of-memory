import {Component, OnDestroy, OnInit} from '@angular/core';
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {Deck} from "../../../../shared/models/deck.model";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {take} from "rxjs/operators";
import {BehaviorSubject, Observable, Subscription} from "rxjs";
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

  route$: Observable<Params>;
  routeSub$: Subscription;
  fetchTrigger$ = new BehaviorSubject(null);

  id: string;
  deck: Deck;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService,
    public dialog: DialogService,
    private deckBackend: DecksBackendService,
    private cardBackend: CardsBackendService
  ) { }

  ngOnInit(): void {
    this.route$ = this.route.params;

    this.routeSub$ = this.route$.subscribe(params => {
      this.id = params['deck'];
      this.fetchTrigger$.next(this.id);
    });

    this.fetchTrigger$.subscribe(id => {
      this.deckBackend.getDeck(id).pipe(take(1)).subscribe(d => this.deck = d);
    });
  }

  ngOnDestroy(): void {
    this.fetchTrigger$.unsubscribe();
    this.routeSub$.unsubscribe();
  }

  deleteCard(id: string): void {
    const res = this.dialog.open({
      data: {
        type: DialogType.WARNING,
        title: 'Delete Flashcard',
        message: 'Are you sure about deleting the flashcard? This action is irreversible.',
        submitMessage: 'Delete'
      },
    });

    res.afterClosed.pipe(take(1)).subscribe(cause => {
      if(cause !== 'submit')
        return;

      this.cardBackend.deleteCard(id).pipe(take(1))
        .subscribe(
          s => this.toastr.success("Flashcard deleted.", "Success!"),
          e => this.toastr.error("Flashcard could not be deleted.", "Failed!")
        );
    });
  }

  deleteDeck() {
    const res = this.dialog.open({
      data: {
        type: DialogType.WARNING,
        title: 'Delete Deck',
        message: 'Are you sure about deleting this deck? This action is irreversible.',
        submitMessage: 'Delete'
      },
    });

    res.afterClosed.pipe(take(1)).subscribe(cause => {
      if(cause !== 'submit')
        return;

      this.deckBackend.deleteDeck(this.id).pipe(take(1))
        .subscribe(
          s => {
            void this.router.navigate(['/decks'])
            this.toastr.success("Deck deleted.", "Success!");
          },
          e => this.toastr.error("Deck could not be deleted.", "Failed!")
        );
    });
  }
}
