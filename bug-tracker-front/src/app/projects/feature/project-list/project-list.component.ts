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
  user: any ;
  projects: any[] = [];
  
  constructor(private projectsService: ProjectsService, private auth: AuthService, private utilisateurService: UtilisateursService) {}

  ngOnInit(): void {
    this.utilisateurService.getCurrentUserApiData();
    this.setProjects();
  }

  setProjects() {
    this.projectsService.getProjects().subscribe({
      next: (data: any[]) => {
        this.projects = data;
        console.log('Résultat de la requête API :', this.projects);
      },
      error: (error) => {
        console.error('Erreur lors de la requête API :', error);
      }
    });
  }
}