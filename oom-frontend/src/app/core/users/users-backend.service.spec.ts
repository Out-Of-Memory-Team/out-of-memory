import { TestBed } from '@angular/core/testing';

import { UsersBackendService } from './users-backend.service';

describe('UsersBackendService', () => {
  let service: UsersBackendService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsersBackendService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
