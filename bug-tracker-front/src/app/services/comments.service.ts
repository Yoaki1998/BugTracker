import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {
  private apiUrl = environment.apiUrl + '/projects';
  

  constructor(private http: HttpClient) { }

  createComment(body: any | null): Observable<any> {
    return this.http.post(this.apiUrl, body)
  }

  getComments(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}
