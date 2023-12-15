import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignedPeopleComponent } from './assigned-people.component';

describe('AssignedPeopleComponent', () => {
  let component: AssignedPeopleComponent;
  let fixture: ComponentFixture<AssignedPeopleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AssignedPeopleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AssignedPeopleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
