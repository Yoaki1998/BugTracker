import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketDetailsDumbComponent } from './ticket-details-dumb.component';

describe('TicketDetailsDumbComponent', () => {
  let component: TicketDetailsDumbComponent;
  let fixture: ComponentFixture<TicketDetailsDumbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TicketDetailsDumbComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TicketDetailsDumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
