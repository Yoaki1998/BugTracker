import { Component, OnInit } from '@angular/core';
import { ProjectsService } from '../../data-access/projects.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project-details',
  template: ` <h1>Project Liste</h1> 
  <app-project-details-dumb [project]="project" ></app-project-details-dumb>
  <app-ticket-list [tickets]="tickets" ></app-ticket-list>
`,
  styles: ''
})
export class ProjectDetailsComponent implements OnInit {

  project: any;
  tickets: any[] = [];

  constructor(private projectsService: ProjectsService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    const projectId: number = Number(this.router.snapshot.paramMap.get('id'));
    this.setProject(projectId);

  }

  setProject(projectId: number) {
    this.projectsService.getOneProject(projectId).subscribe({
      next: (data: any) => {
        this.project = data;
        console.log('Résultat de la requête API :', this.project);
      },
      error: (error) => {
        console.error('Erreur lors de la requête API :', error);
      }
    });
  }



}

