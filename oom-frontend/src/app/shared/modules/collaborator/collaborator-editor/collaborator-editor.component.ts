import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from "../../../models/user.model";
import {UsersBackendService} from "../../../../core/users/users-backend.service";

@Component({
  selector: 'collaborator-editor',
  templateUrl: './collaborator-editor.component.html',
  styleUrls: ['./collaborator-editor.component.scss']
})
export class CollaboratorEditorComponent {

  @Input() collaborators: User[] = [];

  @Output() collaboratorsChange: EventEmitter<User[]> = new EventEmitter<User[]>();

  selected: number = -1;
  openAdd: boolean = false;

  constructor(private usersBackend: UsersBackendService) { }

  select(index: number): void {
    this.selected = index;
  }

  delete(index: number): void {
    this.collaborators.splice(index, 1);
    this.collaboratorsChange.emit(this.collaborators);
  }

  add(collaborator: User): void {
    this.collaborators.push(collaborator);
    this.collaboratorsChange.emit(this.collaborators);
  }

  triggerAddModal(): void {
    this.openAdd = true;
  }
}
