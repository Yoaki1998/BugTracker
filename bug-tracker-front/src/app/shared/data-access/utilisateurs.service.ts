import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { environment } from '../../../environments/environment.development';
import { Observable, catchError, of, switchMap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UtilisateursService {

  private apiUrlProject = environment.apiUrl + '/utilisateurs';

  private userId: string | undefined = "";

  constructor(private http: HttpClient, private auth: AuthService) { }

  getCurrentUserApiData(): Observable<any> {
    return this.auth.user$.pipe(
      switchMap(userdata => {
        this.userId = userdata?.sub;
        console.log(this.userId);
        return this.http.get(this.apiUrlProject + `/${this.userId}`);
      }),
      catchError(error => {
        console.log(error);
        return of(null);
      })
    );
  }

  getUserById(userId: string): Observable<any> {
    return this.http.get(this.apiUrlProject + `/${userId}`);
  }


}

