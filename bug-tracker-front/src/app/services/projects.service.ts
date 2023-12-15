import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {
  private apiUrlProject = environment.apiUrl + '/projects';

  constructor(private http: HttpClient) { }
  
  createProject(body: any | null): Observable<any> {
    return this.http.post(this.apiUrlProject, body)
  }

  getProjects(): Observable<any> {
    return this.http.get(this.apiUrlProject);
  }

  getOneProject(id: Number): Observable<any> {
    return this.http.get(this.apiUrlProject + `/${id}`)
  }

  updateProject(body: any | null, id: Number): Observable<any> {
    return this.http.put(this.apiUrlProject + `/${id}`, body)
  }

  deleteProject(id: Number): Observable<any> {
    return this.http.delete(this.apiUrlProject +`/${id}`)
  }

  getTicketFor(id: Number): Observable<any> {
    return this.http.get(this.apiUrlProject + `/${id}/tickets`);
  }
}