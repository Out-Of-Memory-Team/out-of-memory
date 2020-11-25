import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TagEditorComponent} from './tag-editor/tag-editor.component';
import {ClrFormsModule, ClrIconModule, ClrModalModule} from "@clr/angular";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [TagEditorComponent],
  imports: [
    CommonModule,
    ClrIconModule,
    ClrModalModule,
    FormsModule,
    ClrFormsModule
  ],
  exports: [
    TagEditorComponent
  ]
})
export class TagsModule { }
