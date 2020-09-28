import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociatemenuComponent } from './associatemenu.component';

describe('AssociatemenuComponent', () => {
  let component: AssociatemenuComponent;
  let fixture: ComponentFixture<AssociatemenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssociatemenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociatemenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
