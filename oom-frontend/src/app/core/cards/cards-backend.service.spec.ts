import {TestBed} from '@angular/core/testing';

import {CardsBackendService} from './cards-backend.service';

describe('CardsBackendService', () => {
  let service: CardsBackendService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardsBackendService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
