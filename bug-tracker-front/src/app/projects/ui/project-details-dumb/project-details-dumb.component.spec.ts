import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectDetailsDumbComponent } from './project-details-dumb.component';

describe('ProjectDetailsDumbComponent', () => {
  let component: ProjectDetailsDumbComponent;
  let fixture: ComponentFixture<ProjectDetailsDumbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProjectDetailsDumbComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProjectDetailsDumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
