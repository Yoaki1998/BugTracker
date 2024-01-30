import { Component, OnInit } from '@angular/core';
import { ProjectsService } from '../../data-access/projects.service';
import { ActivatedRoute } from '@angular/router';
import { UtilisateursService } from '../../../shared/data-access/utilisateurs.service';

@Component({
  selector: 'app-project-details',
  template: `<app-project-details-dumb [project]="project" ></app-project-details-dumb>
  <app-project-ticket-list [tickets]="tickets" ></app-project-ticket-list>
  <app-assigned-people [staff]="staff" ></app-assigned-people>
`,
  styles: ''
})
export class ProjectDetailsComponent implements OnInit {

  project: any;
  tickets: any[] = [];
  staffIds: any[] = [];
  staff: any[] = [];

  constructor(private projectsService: ProjectsService, private router: ActivatedRoute, private utilisateurService: UtilisateursService) { }

  ngOnInit(): void {
    const projectId: number = Number(this.router.snapshot.paramMap.get('id'));
    this.setProjectDetails(projectId);

  }

  setProjectDetails(projectId: number) {
    this.projectsService.getOneProject(projectId).subscribe({
      next: (data: any) => {
        this.project = data;
        this.tickets = data.tickets;

        for ( let i = 0 ; i <= this.tickets.length - 1; i++) { 
          if ( !this.staffIds.includes(this.tickets[i].assignedTo ) ) { 
            this.staffIds.push( this.tickets[i].assignedTo )  }
        };
    
    
        this.staffIds.map( userId => {
          this.utilisateurService.getUserById(userId).subscribe({
            next: (data:any) => {return this.staff.push(data)}
          })
         })
    
        console.log('Résultat de la requête API :', this.project);


      },
      error: (error) => {
        console.error('Erreur lors de la requête API :', error);
      }
    });

    
  }

  



}

