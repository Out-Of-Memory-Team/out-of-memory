import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LearnDeckComponent} from "./learn-deck/learn-deck.component";
import {DeckOverviewComponent} from "../decks/deck-overview/deck-overview.component";

const routes: Routes = [
  { path: '', component: DeckOverviewComponent },
  { path: ':deck', component: LearnDeckComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LearningRoutingModule { }
