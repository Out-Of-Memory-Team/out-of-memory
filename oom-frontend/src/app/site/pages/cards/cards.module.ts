import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CardEditorComponent} from './card-editor/card-editor.component';
import {CardsRoutingModule} from "./cards-routing.module";
import {QuillModule} from "ngx-quill";
import {FormsModule} from "@angular/forms";
import {ClrComboboxModule, ClrDatalistModule} from "@clr/angular";


@NgModule({
  declarations: [CardEditorComponent],
    imports: [
        CommonModule,
        CardsRoutingModule,
        QuillModule,
        FormsModule,
        ClrDatalistModule,
        ClrComboboxModule
    ]
})
export class CardsModule { }
