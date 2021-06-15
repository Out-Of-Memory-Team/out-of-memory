import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HeaderComponent} from './header/header.component';
import {ClrDropdownModule, ClrIconModule} from '@clr/angular';

@NgModule({
  declarations: [
    HeaderComponent
  ],
  imports: [
    CommonModule,
    ClrIconModule,
    ClrDropdownModule
  ],
  exports: [
    HeaderComponent
  ]
})
export class LayoutModule { }
