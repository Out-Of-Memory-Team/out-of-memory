import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GenericDialogComponent} from './generic-dialog/generic-dialog.component';
import {ClrModalModule} from "@clr/angular";
import {DialogService} from "./dialog.service";


@NgModule({
  declarations: [GenericDialogComponent],
  imports: [
    CommonModule,
    ClrModalModule
  ],
  providers: [DialogService]
})
export class DialogModule { }
