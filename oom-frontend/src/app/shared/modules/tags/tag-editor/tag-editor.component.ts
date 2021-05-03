import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Tag} from "../../../models/tag.model";

@Component({
  selector: 'tag-editor',
  templateUrl: './tag-editor.component.html',
  styleUrls: ['./tag-editor.component.scss']
})
export class TagEditorComponent {

  @Input() tags: Tag[] = [];

  @Output() tagsChange: EventEmitter<Tag[]> = new EventEmitter<Tag[]>();
  @Output() tagSelect: EventEmitter<Tag> = new EventEmitter<Tag>();
  @Output() tagDelete: EventEmitter<Tag> = new EventEmitter<Tag>();
  @Output() tagAdd: EventEmitter<Tag> = new EventEmitter<Tag>();

  selected: number = -1;
  addModal: boolean = false;
  newTagName: string;

  constructor() { }

  select(index: number): void {
    this.selected = index;
    this.tagSelect.emit(this.tags[index]);
  }

  delete(index: number): void {
    this.tags.splice(index, 1);
    this.tagsChange.emit(this.tags);
    this.tagDelete.emit(this.tags[index]);
  }

  add(tag: Tag): void {
    this.tags.push(tag);
    this.tagsChange.emit(this.tags);
    this.tagAdd.emit(tag);
  }

  triggerAddModal(): void {
    this.addModal = true;
  }

  closeAddModal(): void {
    this.addModal = false;
    this.newTagName = '';
  }

  submitAddModal(): void {
    if(!this.tags.findIndex(t => t.name === this.newTagName.toLowerCase()))
      return;

    this.add(new Tag(this.newTagName.toLowerCase()));
    this.closeAddModal();
  }
}
