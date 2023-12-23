import { Component, OnInit } from '@angular/core';
import { UtilisateursService } from '../../../shared/data-access/utilisateurs.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  tickets: any [] = [];

  constructor(private utilisateurService: UtilisateursService) {}

  ngOnInit(): void {
    this.setTickets();
    }
  
    setTickets() {
      this.utilisateurService.getCurrentUserApiData().subscribe({
        next: (data) => {
          var assigned = data.assigned
          var submitted = data.submitted
          var a = assigned.concat(submitted)
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
