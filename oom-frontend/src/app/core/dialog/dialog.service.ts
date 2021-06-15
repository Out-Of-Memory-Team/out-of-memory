import {
  ApplicationRef,
  ComponentFactoryResolver,
  ComponentRef,
  EmbeddedViewRef,
  Injectable,
  Injector
} from '@angular/core';
import {GenericDialogComponent} from "./generic-dialog/generic-dialog.component";
import {DialogInjector} from "./dialog-data/dialog-injector";
import {DialogConfig} from "./dialog-data/dialog-config";
import {DialogRef} from "./dialog-data/dialog-ref";

@Injectable()
export class DialogService {

  dialogComponentRef: ComponentRef<GenericDialogComponent>;

  constructor(
    private componentFactoryResolver: ComponentFactoryResolver,
    private appRef: ApplicationRef,
    private injector: Injector
  ) { }

  public open(config: DialogConfig): DialogRef {
    return this.appendToBody(config);
  }

  appendToBody(config: DialogConfig): DialogRef {
    // create DialogConfig
    const map = new WeakMap();
    map.set(DialogConfig, config);
    const injector = new DialogInjector(this.injector, map);

    // create DialogRef
    const dialogRef = new DialogRef();
    map.set(DialogRef, dialogRef);
    const sub = dialogRef.afterClosed.subscribe(() => {
      this.removeFromBody();
      sub.unsubscribe();
    });

    // create DialogComponent
    const factory = this.componentFactoryResolver.resolveComponentFactory(GenericDialogComponent);
    const componentRef = factory.create(injector);
    this.appRef.attachView(componentRef.hostView);

    const domElem = (componentRef.hostView as EmbeddedViewRef<any>).rootNodes[0] as HTMLElement;
    document.body.appendChild(domElem);

    this.dialogComponentRef = componentRef;

    // return DialogRef
    return dialogRef;
  }

  private removeFromBody(): void {
    this.appRef.detachView(this.dialogComponentRef.hostView);
    this.dialogComponentRef.destroy();
  }
}
