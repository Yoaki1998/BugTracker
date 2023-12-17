import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectListComponent } from './projects/feature/project-list/project-list.component';
import { ProjectDetailsComponent } from './projects/feature/project-details/project-details.component';

const routes: Routes = [
  { path: 'projects', component: ProjectListComponent },
  { path: 'project/:id', component: ProjectDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
