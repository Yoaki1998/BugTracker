import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { AuthService } from '@auth0/auth0-angular';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {

  private apiUrlProject = environment.apiUrl + '/projects';

  constructor(private http: HttpClient, private auth: AuthService) {}

  createProject(body: any | null): Observable<any> {
    return this.http.post(this.apiUrlProject, body);
  }

  getProjects(): Observable<any> {
    if (this.auth.isAuthenticated$) {
      this.auth.getAccessTokenSilently({cacheMode: "on"}).subscribe({
        next: (newToken) => {
          console.log(newToken)
        },
        error: (error) => {
          console.log('Error access token :', error);
        }
      });
   }
    return this.http.get(this.apiUrlProject);
  }

  getOneProject(id: Number): Observable<any> {
    return this.http.get(this.apiUrlProject + `/${id}`);
  }

  updateProject(body: any | null, id: Number): Observable<any> {
    return this.http.put(this.apiUrlProject + `/${id}`, body);
  }

  deleteProject(id: Number): Observable<any> {
    return this.http.delete(this.apiUrlProject + `/${id}`);
  }

}