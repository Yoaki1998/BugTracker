import { Component, OnInit } from '@angular/core';
import { ProjectsService } from '../../../services/projects.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  projects: any[] = [];
  
  constructor(private projectsService: ProjectsService) {}

  ngOnInit(): void {
    this.projectsService.getProjects().subscribe({
      next: (data) => {
        this.projects = data
        console.log('Résultat de la requête API :', this.projects);
      },
      error: (error) => {
        console.error('Erreur lors de la requête API :', error);
      }
    });

    this.projectsService.deleteProject(7)
    .subscribe({
      next: () => {
        console.log(`Le projet d'ID 7 a été supprimé avec succès.`);
      },
      error: error => {
        console.error(`Erreur lors de la suppression du projet : ${error}`);
      }
    });
  }
}