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
  @Output() collaboratorSelect: EventEmitter<User> = new EventEmitter<User>();
  @Output() collaboratorDelete: EventEmitter<User> = new EventEmitter<User>();
  @Output() collaboratorAdd: EventEmitter<User> = new EventEmitter<User>();

  selected: number = -1;
  openModal: boolean = false;
  newCollaboratorName: string;

  constructor(private usersBackend: UsersBackendService) { }

  select(index: number): void {
    this.selected = index;
    this.collaboratorSelect.emit(this.collaborators[index]);
  }

  delete(index: number): void {
    this.collaborators.splice(index, 1);
    this.collaboratorsChange.emit(this.collaborators);
    this.collaboratorDelete.emit(this.collaborators[index]);
  }

  add(collaborator: User): void {
    this.openModal = false;
    this.collaborators.push(collaborator);
    this.collaboratorsChange.emit(this.collaborators);
    this.collaboratorAdd.emit(collaborator);
  }

  triggerAddModal(): void {
    this.openModal = true;
  }

  closeAddModal(): void {
    this.openModal = false;
    this.newCollaboratorName = '';
  }

  submitAddModal(): void {
    if(!this.collaborators.findIndex(t => t.username === this.newCollaboratorName))
      return;

    this.usersBackend.getUserByUsername(this.newCollaboratorName).subscribe(user => {
      this.add(user);
      this.closeAddModal();
    })
  }
}
