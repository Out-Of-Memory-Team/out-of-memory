import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../models/user.model";

@Component({
  selector: 'maintainer-editor',
  templateUrl: './maintainer-editor.component.html',
  styleUrls: ['./maintainer-editor.component.scss']
})
export class MaintainerEditorComponent implements OnInit {

  @Input() user: User = new User();

  newMaintainerName: String = "";
  openEdit: boolean;

  constructor() { }

  ngOnInit(): void {
  }

  triggerEdit() {
    this.openEdit = true;
  }

  save(user: User){
    this.user = user;
  }
}
