import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketsService {
  private apiUrl = environment.apiUrl + '/projects';

  constructor(private http: HttpClient) { }

  createTicket(body: any | null): Observable<any> {
    return this.http.post(this.apiUrl, body)
  }

  getTickets(): Observable<any> {
    return this.http.get(this.apiUrl)
  }

  getOneTicket(id: Number): Observable<any> {
    return this.http.get(this.apiUrl +`/${id}`)
  }

  updateTicket(id : Number, body :any | null) {
    return this.http.put(this.apiUrl +`/${id}`, body)
  }
}
