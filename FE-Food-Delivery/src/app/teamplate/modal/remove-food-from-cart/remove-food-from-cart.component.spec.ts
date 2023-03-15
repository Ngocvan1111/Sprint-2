import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveFoodFromCartComponent } from './remove-food-from-cart.component';

describe('RemoveFoodFromCartComponent', () => {
  let component: RemoveFoodFromCartComponent;
  let fixture: ComponentFixture<RemoveFoodFromCartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemoveFoodFromCartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveFoodFromCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
