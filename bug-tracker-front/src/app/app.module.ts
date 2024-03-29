import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AuthModule } from '@auth0/auth0-angular';
import { environment } from '../environments/environment.development';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { ProjectListComponent } from './projects/feature/project-list/project-list.component';
import { ProjectDetailsComponent } from './projects/feature/project-details/project-details.component';
import { ProjectListDumbComponent } from './projects/ui/project-list-dumb/project-list-dumb.component';
import { ProjectDetailsDumbComponent } from './projects/ui/project-details-dumb/project-details-dumb.component';
import { ProjectTicketListComponent } from './projects/ui/ticket-list/project-ticket-list.component';
import { AssignedPeopleComponent } from './projects/ui/assigned-people/assigned-people.component';

import { AuthButtonComponent } from './shared/Auth0/login-button.component';
import { AuthInterceptor } from './shared/Auth0/auth.interceptor';

import { TicketDetailsComponent } from './tickets/feature/ticket-details/ticket-details.component';
import { TicketDetailsDumbComponent } from './tickets/ui/ticket-details-dumb/ticket-details-dumb.component';
import { TicketListDumbComponent } from './tickets/ui/ticket-list-dumb/ticket-list-dumb.component';
import { TicketListComponent } from './tickets/feature/ticket-list/ticket-list.component';
import { HomeComponent } from './home/feature/home/home.component';
import { ManageUserComponent } from './manage/feature/manage-user/manage-user.component';
import { NavbarComponent } from './shared/ui/navbar/navbar.component';
import { SidebarComponent } from './shared/ui/sidebar/sidebar.component';
import { ScreenComponent } from './shared/ui/screen/screen.component';

@NgModule({
  declarations: [
    AppComponent,
    
    ProjectListComponent,
    ProjectDetailsComponent,
    ProjectListDumbComponent,
    ProjectDetailsDumbComponent,
    ProjectTicketListComponent,
    AssignedPeopleComponent,

    AuthButtonComponent,

    TicketDetailsComponent,
    TicketDetailsDumbComponent,
    TicketListDumbComponent,
    TicketListComponent,
    HomeComponent,
    ManageUserComponent,
    NavbarComponent,
    SidebarComponent,
    ScreenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AuthModule.forRoot(environment.auth),
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true,
  },],
  bootstrap: [AppComponent]
})
export class AppModule { }
