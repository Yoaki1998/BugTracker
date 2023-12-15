import { Component, OnInit } from '@angular/core';
import { ProjectsService } from '../../data-access/projects.service';

@Component({
  selector: 'app-project-list',
  template: '',
  styles: []
})
export class ProjectListComponent implements OnInit {
  projects: any[] = [];
  
  constructor(private projectsService: ProjectsService) {}

  ngOnInit(): void {

  }
}