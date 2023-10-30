import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatchServiceService } from '../services/match-service.service';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.scss'],
})
export class MatchesComponent implements OnInit {
  matches: any = [];
  editId: number | null = null;

  constructor(private matchService: MatchServiceService) {}
  formMatch!: FormGroup;

  ngOnInit() {
    this.getAllMatches();
    this.formMatch = new FormGroup({
      localTeam: new FormControl(''),
      awayTeam: new FormControl(''),
      matchDateTime: new FormControl(''),
      stadium: new FormControl(''),
    });
  }

  getAllMatches() {
    this.matchService.getMatches().subscribe((response) => {
      this.matches = response;
    });
  }

  addMatch() {
    const localTeam = this.formMatch.get('localTeam')?.value;
    const awayTeam = this.formMatch.get('awayTeam')?.value;
    const matchDateTime = this.formMatch.get('matchDateTime')?.value;
    const stadium = this.formMatch.get('stadium')?.value;

    this.matchService.addMatch(localTeam, awayTeam, matchDateTime, stadium).subscribe((response) => {
      this.getAllMatches();
      this.formMatch.reset();
    });
  }

  deleteMatch(id: number) {
    this.matchService.deleteMatch(id).subscribe((response) => {
      this.getAllMatches();
    });
  }

  editMatch() {
    const localTeam = this.formMatch.get('localTeam')?.value;
    const awayTeam = this.formMatch.get('awayTeam')?.value;
    const matchDateTime = this.formMatch.get('matchDateTime')?.value;
    const stadium = this.formMatch.get('stadium')?.value;
    const id = this.editId;

    if (id == null) {
      return console.log('Error, el id no puede ser nulo');
    }

    this.matchService.editMatch(id, localTeam, awayTeam, matchDateTime, stadium).subscribe((response) => {
      this.getAllMatches();
      this.formMatch.reset();
    });
  }

  enableEdit(match: any, id: number) {
    this.editId = id;
    this.formMatch.setValue({
      localTeam: match.localTeam,
      awayTeam: match.awayTeam,
      matchDateTime: match.matchDateTime,
      stadium: match.stadium,
    });
  }
}
