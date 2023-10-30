import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class MatchServiceService {
  endpoint = 'http://localhost:8080/Matches';

  constructor(private httpClient: HttpClient) {}

  getMatches() {
    return this.httpClient.get(this.endpoint);
  }

  deleteMatch(id: number) {
    return this.httpClient.delete(this.endpoint + `/${id}`);
  }

  addMatch(localTeam: string, awayTeam: string, matchDateTime: string, stadium: string): Observable<string> {
    return this.httpClient.post<string>(
      this.endpoint,
      { localTeam, awayTeam, matchDateTime, stadium },
      httpOptions
    );
  }

  editMatch(id: number, localTeam: string, awayTeam: string, matchDateTime: string, stadium: string): Observable<string> {
    return this.httpClient.put<string>(
      this.endpoint + `/${id}`,
      { localTeam, awayTeam, matchDateTime, stadium },
      httpOptions
    );
  }
}

