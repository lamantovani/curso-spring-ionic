import { TestBed } from '@angular/core/testing';

import { LoginServiceProviderService } from './login-service-provider.service';

describe('LoginServiceProviderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginServiceProviderService = TestBed.get(LoginServiceProviderService);
    expect(service).toBeTruthy();
  });
});
