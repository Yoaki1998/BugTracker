import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {
  private apiUrl = environment.apiUrl + '/projects';

  constructor(private http: HttpClient) { }
  
  createProject(body: any | null): Observable<any> {
    return this.http.post(this.apiUrl, body)
  }

  getProjects(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getOneProject(id: Number): Observable<any> {
    return this.http.get(this.apiUrl + `/${id}`)
  }

  updateProject(body: any | null, id: Number): Observable<any> {
    return this.http.put(this.apiUrl + `/${id}`, body)
  }

  deleteProject(id: Number): Observable<any> {
    const finalUrl = this.apiUrl +`/${id}`
    console.log(finalUrl)
    return this.http.delete(finalUrl)
  }
}