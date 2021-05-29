import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LearnDeckComponent } from './learn-deck/learn-deck.component';
import {LearningRoutingModule} from "./learning-routing.module";
import {QuillModule} from "ngx-quill";
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [LearnDeckComponent],
  imports: [
    CommonModule,
    LearningRoutingModule,
    QuillModule,
    FormsModule
  ]
})
export class LearningModule { }
