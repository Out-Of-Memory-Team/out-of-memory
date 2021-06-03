import { Component, OnInit } from '@angular/core';
import {interval, Subscription} from "rxjs";
import {Deck} from "../../../../shared/models/deck.model";
import {take} from "rxjs/operators";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {ToastrService} from "ngx-toastr";
import {DialogService} from "../../../../core/dialog/dialog.service";
import {DecksBackendService} from "../../../../core/decks/decks-backend.service";
import {Flashcard} from "../../../../shared/models/flashcard.model";

@Component({
  selector: 'app-learn-deck',
  templateUrl: './learn-deck.component.html',
  styleUrls: ['./learn-deck.component.scss']
})
export class LearnDeckComponent implements OnInit {

  routeSub: Subscription;

  id: string;
  deck: Deck;
  currentCard: Flashcard;

  counterMax: number;
  counter: number = 0;
  learnRate: number = 0;

  solutionOpen: boolean = false;
  finished: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private toastr: ToastrService,
    private deckBackend: DecksBackendService,) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.id = params['deck'];

      this.deckBackend.getDeck(this.id).pipe(take(1))
        .subscribe(
          d => {
            this.deck = d;
            this.counterMax = d.flashcards.length;
          },
          e => this.toastr.error('Deck could not be retrieved.', 'Failed!')
        );
    });
  }

  openAnswer() {
    this.solutionOpen = true;
  }

  closeSolution() {
    this.solutionOpen = false;
  }

  nextCard() {
    if(this.deck.flashcards.length > 0) {
      this.solutionOpen = false;
      this.currentCard = this.deck.flashcards.shift();
    } else {
      this.stop();
    }
  }

  done() {
    this.counter++;
    this.learnRate = Math.round((this.counter / this.counterMax)*100);
    this.nextCard();
  }

  again() {
    this.deck.flashcards.push(this.currentCard);
    this.nextCard();
  }

  start() {
    this.startTimer();
    this.nextCard();
  }

  stop() {
    this.currentCard = null;
    this.finished = true;
    this.timer.unsubscribe();
  }

  timer: Subscription;
  time: number = 0;
  seconds: number = 0;
  minutes: number = 0;

  startTimer() {
    this.timer = interval(1000).subscribe(x => {
      this.time++;
      this.seconds = this.time % 60;
      this.minutes = Math.floor(this.time/60);
    })
  }
}
