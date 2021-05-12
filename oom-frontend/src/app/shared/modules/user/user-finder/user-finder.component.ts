import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UsersBackendService} from "../../../../core/users/users-backend.service";
import {User} from "../../../models/user.model";

@Component({
  selector: 'user-finder',
  templateUrl: './user-finder.component.html',
  styleUrls: ['./user-finder.component.scss']
})
export class UserFinderComponent implements OnInit {

  keyword: string = '';
  suggestions: string[][] = [];

  @Input()
  openModal: boolean;

  @Output() openModalChange: EventEmitter<boolean> = new EventEmitter<boolean>();

  @Input()
  title: string;

  @Output()
  userSelect: EventEmitter<User> = new EventEmitter<User>();

  constructor(private usersService: UsersBackendService) { }

  ngOnInit(): void {
  }

  closeModal() {
    this.openModal = false;
    this.openModalChange.emit(false)
    this.keyword = '';
  }

  submitModal() {
    this.usersService.getUserByUsername(this.keyword).subscribe(res => {
      if(res) {
        this.userSelect.emit(res)
        this.closeModal()
      } else {
        this.keyword = '';
      }
    }, err => {
      this.keyword = '';
    });
  }

  changeInput() {
    if(this.keyword.length > 3)
      this.usersService.getUserByKeyword(this.keyword).subscribe(res => this.suggestions = res);
  }
}
