import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ClarityModule} from '@clr/angular';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LayoutModule} from './site/layout/layout.module';
import {LandingModule} from './site/pages/landing/landing.module';
import {DeckOverviewComponent} from './site/pages/decks/deck-overview/deck-overview.component';
import {DeckDetailComponent} from './site/pages/decks/deck-detail/deck-detail.component';
import {DeckEditorComponent} from './site/pages/decks/deck-editor/deck-editor.component';
import {PipesModule} from "./shared/pipes/pipes.module";
import {QuillModule} from "ngx-quill";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    DeckOverviewComponent,
    DeckDetailComponent,
    DeckEditorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ClarityModule,
    BrowserAnimationsModule,
    QuillModule.forRoot(),
    LayoutModule,
    LandingModule,
    PipesModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
