import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectListComponent } from './projects/feature/project-list/project-list.component';
import { ProjectDetailsComponent } from './projects/feature/project-details/project-details.component';
import { TicketDetailsComponent } from './tickets/feature/ticket-details/ticket-details.component';
import { TicketListComponent } from './tickets/feature/ticket-list/ticket-list.component';

const routes: Routes = [
  { path: 'projects', component: ProjectListComponent },
  { path: 'project/:id', component: ProjectDetailsComponent },
  { path: 'tickets', component: TicketListComponent },
  { path: 'ticket/:id', component: TicketDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
