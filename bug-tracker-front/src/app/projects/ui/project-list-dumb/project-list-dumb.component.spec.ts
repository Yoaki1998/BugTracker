import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectListDumbComponent } from './project-list-dumb.component';

describe('ProjectListDumbComponent', () => {
  let component: ProjectListDumbComponent;
  let fixture: ComponentFixture<ProjectListDumbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProjectListDumbComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProjectListDumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
