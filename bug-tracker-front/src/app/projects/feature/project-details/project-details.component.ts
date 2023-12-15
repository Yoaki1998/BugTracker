import { Component, OnInit } from '@angular/core';
import { ProjectsService } from '../../data-access/projects.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-project-details',
  template: ' <h1>Project Details</h1> ',
  styles: ''
})
export class ProjectDetailsComponent implements OnInit {

  project: any;
  tickets: any[] = [];

  constructor(private projectsService: ProjectsService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    const projectId: number = Number(this.router.snapshot.paramMap.get('id'));
    this.setProject(projectId);
    this.setTickets(projectId)

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

  setTickets(projectId: number) {
    this.projectsService.getTicketFor(projectId).subscribe({
      next: (data: any[]) => {
        this.tickets = data;
        console.log('Résultat de la requête API :', this.tickets);
      },
      error: (error) => {
        console.error('Erreur lors de la requête API :', error);
      }
    });
  }

}

