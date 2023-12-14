import { Component, OnInit } from '@angular/core';
import { ProjectsService } from '../../services/projects.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  constructor(private projectsService: ProjectsService) {}

  ngOnInit(): void {
    this.projectsService.getProjects().subscribe(
      (data) => {
        console.log('Résultat de la requête API :', data);
      },
      (error) => {
        console.error('Erreur lors de la requête API :', error);
      }
    );
  }
}