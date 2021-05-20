import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaintainerEditorComponent } from './maintainer-editor/maintainer-editor.component';
import {ClrFormsModule, ClrIconModule} from "@clr/angular";
import {FormsModule} from "@angular/forms";
import {UserModule} from "../user/user.module";



@NgModule({
  declarations: [MaintainerEditorComponent],
  exports: [
    MaintainerEditorComponent
  ],
  imports: [
    CommonModule,
    ClrFormsModule,
    FormsModule,
    ClrIconModule,
    UserModule
  ]
})
export class MaintainerModule { }
