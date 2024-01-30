import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit  {
  public href: string = window.location.href;
  public title: string = "";

  ngOnInit(): void {
    this.chooseTitle()
  }

  chooseTitle() {
    if (this.href.includes('http://localhost:4200')) { this.title = "Home" }
    if (this.href.includes('http://localhost:4200/project')) { this.title = "Projet" }
    if (this.href.includes('http://localhost:4200/ticket')) { this.title = "Ticket" }
    if (this.href.includes('http://localhost:4200/projects')) { this.title = "Liste des Projets" }
    if (this.href.includes('http://localhost:4200/tickets')) { this.title = " Liste des Tickets" }
  }

}
