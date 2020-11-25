import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CardEditorComponent} from './card-editor/card-editor.component';
import {CardsRoutingModule} from "./cards-routing.module";
import {QuillModule} from "ngx-quill";
import {FormsModule} from "@angular/forms";
import {ClrDatalistModule} from "@clr/angular";


@NgModule({
  declarations: [CardEditorComponent],
  imports: [
    CommonModule,
    CardsRoutingModule,
    QuillModule,
    FormsModule,
    ClrDatalistModule
  ]
})
export class CardsModule { }
