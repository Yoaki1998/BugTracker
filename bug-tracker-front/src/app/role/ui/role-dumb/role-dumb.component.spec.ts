import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoleDumbComponent } from './role-dumb.component';

describe('RoleDumbComponent', () => {
  let component: RoleDumbComponent;
  let fixture: ComponentFixture<RoleDumbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RoleDumbComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RoleDumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
