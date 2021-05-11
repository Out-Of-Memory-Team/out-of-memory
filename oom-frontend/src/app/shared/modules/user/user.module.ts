import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFinderComponent } from './user-finder/user-finder.component';
import {ClrFormsModule, ClrModalModule} from "@clr/angular";
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [UserFinderComponent],
  exports: [
    UserFinderComponent
  ],
  imports: [
    CommonModule,
    ClrFormsModule,
    FormsModule,
    ClrModalModule
  ]
})
export class UserModule { }
