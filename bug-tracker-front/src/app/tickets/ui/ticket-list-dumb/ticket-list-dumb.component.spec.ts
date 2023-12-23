import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketListDumbComponent } from './ticket-list-dumb.component';

describe('TicketListDumbComponent', () => {
  let component: TicketListDumbComponent;
  let fixture: ComponentFixture<TicketListDumbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TicketListDumbComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TicketListDumbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
