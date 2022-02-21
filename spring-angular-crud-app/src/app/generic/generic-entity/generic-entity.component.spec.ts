import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenericEntityComponent } from './generic-entity.component';

describe('GenericEntityComponent', () => {
  let component: GenericEntityComponent;
  let fixture: ComponentFixture<GenericEntityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenericEntityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenericEntityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
