import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociatetasksComponent } from './associatetasks.component';

describe('AssociatetasksComponent', () => {
  let component: AssociatetasksComponent;
  let fixture: ComponentFixture<AssociatetasksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssociatetasksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociatetasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
