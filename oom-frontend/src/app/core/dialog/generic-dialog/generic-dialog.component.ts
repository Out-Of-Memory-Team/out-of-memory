import {Component, OnInit} from '@angular/core';
import {DialogConfig} from "../dialog-data/dialog-config";
import {DialogType} from "../dialog-data/dialog-type.enum";
import {DialogRef} from "../dialog-data/dialog-ref";

@Component({
  selector: 'generic-dialog',
  templateUrl: './generic-dialog.component.html',
  styleUrls: ['./generic-dialog.component.scss']
})
export class GenericDialogComponent implements OnInit {

  dialogType = DialogType;

  constructor(public config: DialogConfig, public dialog: DialogRef) { }

  ngOnInit(): void {
  }

  onCancel() {
    this.dialog.close('cancel')
  }

  onSubmit() {
    this.dialog.close('submit')
  }
}
