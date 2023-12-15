import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {
  private apiUrl = environment.apiUrl + '/projects';
  

  constructor(private http: HttpClient) {}
}
