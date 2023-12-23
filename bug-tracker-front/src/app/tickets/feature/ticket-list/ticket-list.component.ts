import { Component, OnInit } from '@angular/core';
import { UtilisateursService } from '../../../shared/data-access/utilisateurs.service';

@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrl: './ticket-list.component.css'
})
export class TicketListComponent implements OnInit {
  submitted: any [] = [] ;
  assigned: any [] = [] ;
  tickets: any [] = [];

  constructor( private utilisateurService: UtilisateursService ) {}

  ngOnInit(): void {
    this.setTickets();
      
  }

  setTickets() {
    this.utilisateurService.getCurrentUserApiData().subscribe({
      next: (data) => {
        this.assigned = data.assigned
        this.submitted = data.submitted
        var a = this.assigned.concat(this.submitted)
        this.tickets = this.uniq_fast(a)
        console.log(this.tickets)



      },
      error: (error) => {
        console.error('API :', error) ;
      }
    });
  }

  private uniq_fast(a: any) {
    var seen: any = {};
    var out = [];
    var len = a.length;
    var j = 0;
    for(var i = 0; i < len; i++) {
         var item = a[i];
         if(seen[item] !== 1) {
               seen[item] = 1;
               out[j++] = item;
         }
    }
    return out;
  }

}
