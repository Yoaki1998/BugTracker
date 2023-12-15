import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-project-details-dumb',
  templateUrl: './project-details-dumb.component.html',
  styleUrl: './project-details-dumb.component.css'
})
export class ProjectDetailsDumbComponent {
  @Input() project:any;

}
