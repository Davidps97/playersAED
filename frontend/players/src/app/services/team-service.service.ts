import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class TeamServiceService {
  endpoint = 'http://localhost:8080/Teams';

  constructor(private httpClient: HttpClient) {}

  getTeams() {
    return this.httpClient.get(this.endpoint);
  }

  deleteTeam(id: number) {
    return this.httpClient.delete(this.endpoint + `/${id}`);
  }

  addTeam(name: string, localKit: string, awayKit: string): Observable<string> {
    return this.httpClient.post<string>(
      this.endpoint,
      { name, localKit, awayKit },
      httpOptions
    );
  }

  editTeam(id: number, name: string, localKit: string, awayKit: string): Observable<string> {
    return this.httpClient.put<string>(
      this.endpoint + `/${id}`,
      { name, localKit, awayKit },
      httpOptions
    );
  }
}
