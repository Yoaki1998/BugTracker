import { Component, OnInit } from '@angular/core';
import { UtilisateursService } from '../../../shared/data-access/utilisateurs.service';

@Component({
  selector: 'app-manage-user',
  templateUrl: './manage-user.component.html',
  styleUrl: './manage-user.component.css'
})
export class ManageUserComponent implements OnInit {

  users: any [] = [];

  constructor ( private utilisateurService: UtilisateursService ) {}

  ngOnInit(): void {
    this.setUsers();
      
  }

  setUsers() {
    this.utilisateurService.getAllUsers().subscribe({
      next: (data) => {
        this.users = data
        console.log(data)
      },
      error: (error) => {
        console.error('API :', error) ;
      }
    });
  }

}
