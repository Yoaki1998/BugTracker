import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { environment } from '../../../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilisateursService {

  private apiUrlProject = environment.apiUrl + '/utilisateurs';

  private userId: string | undefined = "";

  constructor( private http: HttpClient, private auth: AuthService) { }

  getCurrentUserApiData() {
    this.auth.user$.subscribe({
      next: (userdata) => {
        this.userId = userdata?.sub
        console.log(this.apiUrlProject + `/${this.userId}`)
        return this.http.get(this.apiUrlProject + `/${this.userId}`);
      },
      error: (error) => { console.log(error) }
    })
  }


}
