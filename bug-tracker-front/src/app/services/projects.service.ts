import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {
  private apiUrl = environment.apiUrl + '/projects';

  constructor(private http: HttpClient) {}

  getProjects(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}