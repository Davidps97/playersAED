import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TeamServiceService } from '../services/team-service.service';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.scss'],
})
export class TeamsComponent implements OnInit {
  teams: any = [];
  editId: number | null = null;

  constructor(private teamService: TeamServiceService) {}
  formTeam!: FormGroup;

  ngOnInit() {
    this.getAllTeams();
    this.formTeam = new FormGroup({
      name: new FormControl(''),
      localKit: new FormControl(''),
      awayKit: new FormControl(''),
    });
  }

  getAllTeams() {
    this.teamService.getTeams().subscribe((response) => {
      this.teams = response;
    });
  }

  addTeam() {
    const name = this.formTeam.get('name')?.value;
    const localKit = this.formTeam.get('localKit')?.value;
    const awayKit = this.formTeam.get('awayKit')?.value;

    this.teamService.addTeam(name, localKit, awayKit).subscribe((response) => {
      this.getAllTeams();
      this.formTeam.reset();
    });
  }

  deleteTeam(id: number) {
    this.teamService.deleteTeam(id).subscribe((response) => {
      this.getAllTeams();
    });
  }

  editTeam() {
    const name = this.formTeam.get('name')?.value;
    const localKit = this.formTeam.get('localKit')?.value;
    const awayKit = this.formTeam.get('awayKit')?.value;
    const id = this.editId;

    if (id == null) {
      return console.log('Error, el id no puede ser nulo');
    }

    this.teamService.editTeam(id, name, localKit, awayKit).subscribe((response) => {
      this.getAllTeams();
      this.formTeam.reset();
    });
  }

  enableEdit(team: any, id: number) {
    this.editId = id;
    this.formTeam.setValue({
      name: team.name,
      localKit: team.localKit,
      awayKit: team.awayKit,
    });
  }
}

