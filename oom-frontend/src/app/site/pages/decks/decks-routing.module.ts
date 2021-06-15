import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DeckOverviewComponent} from './deck-overview/deck-overview.component';
import {DeckEditorComponent} from './deck-editor/deck-editor.component';
import {DeckDetailComponent} from './deck-detail/deck-detail.component';

const routes: Routes = [
  { path: '', component: DeckOverviewComponent },
  { path: ':deck', component: DeckDetailComponent },
  { path: ':deck/edit', component: DeckEditorComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DecksRoutingModule { }
