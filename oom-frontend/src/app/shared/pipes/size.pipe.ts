import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'size'
})
export class SizePipe implements PipeTransform {

  transform(array: any[]): number {
    return array.length;
  }
}
