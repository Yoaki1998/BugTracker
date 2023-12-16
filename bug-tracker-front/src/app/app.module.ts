import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AuthModule } from '@auth0/auth0-angular';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProjectListComponent } from './projects/feature/project-list/project-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ProjectDetailsComponent } from './projects/feature/project-details/project-details.component';
import { ProjectListDumbComponent } from './projects/ui/project-list-dumb/project-list-dumb.component';
import { ProjectDetailsDumbComponent } from './projects/ui/project-details-dumb/project-details-dumb.component';
import { TicketListComponent } from './projects/ui/ticket-list/ticket-list.component';
import { AssignedPeopleComponent } from './projects/ui/assigned-people/assigned-people.component';
import { AuthButtonComponent } from './shared/Auth0/login-button.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    ProjectDetailsComponent,
    ProjectListDumbComponent,
    ProjectDetailsDumbComponent,
    TicketListComponent,
    AssignedPeopleComponent,
    AuthButtonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AuthModule.forRoot({
      domain: 'dev-yoakiniscoise.eu.auth0.com',
      clientId: 'z5eBSk8b7S5KvJzM3L9ZpxhxDQIuV9PK',
      authorizationParams: {
        redirect_uri: window.location.origin
      }
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
