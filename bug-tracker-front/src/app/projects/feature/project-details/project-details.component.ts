import { Component } from '@angular/core';
import { ProjectsService } from '../../data-access/projects.service';

@Component({
  selector: 'app-project-details',
  template: ' <h1>Project Details</h1> ',
  styles: ''
})
export class ProjectDetailsComponent {
  projects: any[] = [];
  tickets: any[] = [];

  constructor(private projectsService: ProjectsService) {}

}
