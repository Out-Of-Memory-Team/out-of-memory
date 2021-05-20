import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintainerEditorComponent } from './maintainer-editor.component';

describe('MaintainerEditorComponent', () => {
  let component: MaintainerEditorComponent;
  let fixture: ComponentFixture<MaintainerEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaintainerEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MaintainerEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
