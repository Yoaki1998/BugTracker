import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProjectListComponent } from './projects/feature/project-list/project-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ProjectDetailsComponent } from './projects/feature/project-details/project-details.component';
import { ProjectListDumbComponent } from './projects/ui/project-list-dumb/project-list-dumb.component';
import { ProjectDetailsDumbComponent } from './projects/ui/project-details-dumb/project-details-dumb.component';
import { TicketListComponent } from './projects/ui/ticket-list/ticket-list.component';
import { AssignedPeopleComponent } from './projects/ui/assigned-people/assigned-people.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    ProjectDetailsComponent,
    ProjectListDumbComponent,
    ProjectDetailsDumbComponent,
    TicketListComponent,
    AssignedPeopleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
