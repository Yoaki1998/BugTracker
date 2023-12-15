import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-project-list-dumb',
  templateUrl: './project-list-dumb.component.html',
  styleUrl: './project-list-dumb.component.css'
})
export class ProjectListDumbComponent {
  @Input() projects : any;

}
