import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-project-ticket-list',
  templateUrl: './project-ticket-list.component.html',
  styleUrl: './project-ticket-list.component.css'
})
export class ProjectTicketListComponent {
  @Input() tickets:any;
}
