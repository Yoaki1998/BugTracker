import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketsService {
  private apiUrlTicket = environment.apiUrl + '/tickets';
  private apiUrlComment = environment.apiUrl + '/comments';

  constructor(private http: HttpClient) { }

  createTicket(body: any | null): Observable<any> {
    return this.http.post(this.apiUrlTicket, body)
  }

  getTickets(): Observable<any> {
    return this.http.get(this.apiUrlTicket)
  }

  getOneTicket(id: Number): Observable<any> {
    return this.http.get(this.apiUrlTicket +`/${id}`)
  }

  updateTicket(id : Number, body :any | null) {
    return this.http.put(this.apiUrlTicket +`/${id}`, body)
  }

  createComment(body: any | null): Observable<any> {
    return this.http.post(this.apiUrlComment, body)
  }

  getComments(): Observable<any> {
    return this.http.get(this.apiUrlComment);
  }
}
