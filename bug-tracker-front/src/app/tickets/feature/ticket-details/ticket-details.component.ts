import { Component, OnInit } from '@angular/core';
import { TicketsService } from '../../data-access/tickets.service';
import { ActivatedRoute } from '@angular/router';
import { tick } from '@angular/core/testing';

@Component({
  selector: 'app-ticket-details',
  templateUrl: './ticket-details.component.html',
  styleUrl: './ticket-details.component.css'
})
export class TicketDetailsComponent implements OnInit {
  ticket:any;
  comments: [] = [];

  constructor( private ticketService: TicketsService, private router: ActivatedRoute ) {}

  ngOnInit(): void {
    const ticketId: number = Number(this.router.snapshot.paramMap.get('id'));
    this.setTicketDetails(ticketId);
     
  }

  setTicketDetails(ticketId: number) {
    this.ticketService.getOneTicket(ticketId).subscribe({
      next: (data: any) => {
        this.ticket = data;
        this.comments = data.comments;
        console.log(this.ticket)
        console.log(this.comments)
      }
    })
  }

}
