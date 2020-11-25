import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CardEditorComponent} from "./card-editor/card-editor.component";

const routes: Routes = [
  { path: ':card', component: CardEditorComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CardsRoutingModule { }
