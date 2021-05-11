import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollaboratorEditorComponent } from './collaborator-editor.component';

describe('CollaboratorEditorComponent', () => {
  let component: CollaboratorEditorComponent;
  let fixture: ComponentFixture<CollaboratorEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CollaboratorEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CollaboratorEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
