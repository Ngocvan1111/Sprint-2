import { TestBed } from '@angular/core/testing';

import { CartFoodService } from './cart-food.service';

describe('CartFoodService', () => {
  let service: CartFoodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CartFoodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
