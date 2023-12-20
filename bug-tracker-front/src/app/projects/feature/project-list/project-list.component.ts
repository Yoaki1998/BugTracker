import { Component, OnInit } from '@angular/core';
import { ProjectsService } from '../../data-access/projects.service';
import { AuthService } from '@auth0/auth0-angular';
import { UtilisateursService } from '../../../shared/data-access/utilisateurs.service';

@Component({
  selector: 'app-project-list',
  template: ` <h1>Project Liste</h1> 
    <app-project-list-dumb [projects]="projects" ></app-project-list-dumb>
  `,
  styles: []
})
export class ProjectListComponent implements OnInit {
  projects: any[] = [];

  constructor(private projectsService: ProjectsService, private auth: AuthService, private utilisateurService: UtilisateursService) { }

  ngOnInit(): void {
  this.setProjects();
  }

  setProjects() {
    this.utilisateurService.getCurrentUserApiData().subscribe({
      next: (data) => {
        this.projects = data.projects 
      },
      error: (error) => {
        console.error('API :', error) ;
      }
    });
  }
}
