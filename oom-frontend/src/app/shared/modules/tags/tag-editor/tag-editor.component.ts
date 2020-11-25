import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'tag-editor',
  templateUrl: './tag-editor.component.html',
  styleUrls: ['./tag-editor.component.scss']
})
export class TagEditorComponent {

  @Input() tags: string[] = [];

  @Output() tagsChange: EventEmitter<string[]> = new EventEmitter<string[]>();
  @Output() tagSelect: EventEmitter<string> = new EventEmitter<string>();
  @Output() tagDelete: EventEmitter<string> = new EventEmitter<string>();
  @Output() tagAdd: EventEmitter<string> = new EventEmitter<string>();

  selected: number = -1;
  addModal: boolean = false;
  newTag: string;

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

  add(tag: string): void {
    this.tags.push(tag);
    this.tagsChange.emit(this.tags);
    this.tagAdd.emit(tag);
  }

  triggerAddModal(): void {
    this.addModal = true;
  }

  closeAddModal(): void {
    this.addModal = false;
    this.newTag = '';
  }

  submitAddModal(): void {
    if(this.tags.indexOf(this.newTag.toLowerCase()) !== -1)
      return;

    this.add(this.newTag.toLowerCase());
    this.closeAddModal();
  }
}
