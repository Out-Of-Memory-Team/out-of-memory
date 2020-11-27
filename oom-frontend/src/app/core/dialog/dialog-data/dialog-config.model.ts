import {DialogType} from "./dialog-type.enum";

export class DialogConfigData {

  type?: DialogType;

  title?: string;
  message?: string;

  submitMessage?: string;
  cancelMessage?: string;
}
