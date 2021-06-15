import {TestBed} from '@angular/core/testing';

import {DecksBackendService} from './decks-backend.service';

describe('DecksBackendService', () => {
  let service: DecksBackendService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DecksBackendService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
