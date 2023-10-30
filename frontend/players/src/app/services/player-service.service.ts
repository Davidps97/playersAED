import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class PlayerServiceService {
  endpoint = 'http://localhost:8080/players';

  constructor(private httpClient: HttpClient) {}
  getPlayer() {
    return this.httpClient.get(this.endpoint);
  }

  deletePlayer(id: number) {
    return this.httpClient.delete(this.endpoint + `/${id}`);
  }

  addPlayer(name: string, dorsal: number): Observable<string> {
    return this.httpClient.post<string>(
      this.endpoint,
      { name, dorsal },
      httpOptions
    );
  }

  editPlayer(id: number, name: string, dorsal: number): Observable<string> {
    return this.httpClient.put<string>(
      this.endpoint + `/${id}`,
      { name, dorsal },
      httpOptions
    );
  }
}
