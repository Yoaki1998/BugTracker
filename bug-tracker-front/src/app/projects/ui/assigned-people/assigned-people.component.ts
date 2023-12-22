import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-assigned-people',
  templateUrl: './assigned-people.component.html',
  styleUrl: './assigned-people.component.css'
})
export class AssignedPeopleComponent {
  @Input() staff: any;
}
