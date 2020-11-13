import {ComponentFixture, TestBed} from '@angular/core/testing';

import {LandingGuestComponent} from './landing-guest.component';

describe('LandingGuestComponent', () => {
  let component: LandingGuestComponent;
  let fixture: ComponentFixture<LandingGuestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandingGuestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LandingGuestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
