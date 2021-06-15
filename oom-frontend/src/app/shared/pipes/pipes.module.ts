import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SizePipe} from "./size.pipe";

const pipes = [SizePipe];

@NgModule({
  declarations: pipes,
  imports: [
    CommonModule
  ],
  exports: pipes
})
export class PipesModule { }
