import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ClrFormsModule, ClrIconModule, ClrModalModule} from "@clr/angular";
import {FormsModule} from "@angular/forms";
import {CollaboratorEditorComponent} from "./collaborator-editor/collaborator-editor.component";



@NgModule({
  declarations: [CollaboratorEditorComponent],
  imports: [
    CommonModule,
    ClrIconModule,
    ClrModalModule,
    FormsModule,
    ClrFormsModule
  ],
  exports: [CollaboratorEditorComponent]
})
export class CollaboratorModule { }
