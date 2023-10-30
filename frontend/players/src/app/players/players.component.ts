import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PlayerServiceService } from '../services/player-service.service';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.scss'],
})
export class PlayersComponent implements OnInit {
  players: any = [];
  editId: number | null = null;

  constructor(private playerService: PlayerServiceService) {}
  formPlayer!: FormGroup;

  ngOnInit() {
    this.getAllPlayers();
    this.formPlayer = new FormGroup({
      name: new FormControl(''),
      dorsal: new FormControl(''),
    });
  }

  getAllPlayers() {
    this.playerService.getPlayer().subscribe((response) => {
      this.players = response;
    });
  }

  addPlayers() {
    const name = this.formPlayer.get('name')?.value;
    const dorsal = this.formPlayer.get('dorsal')?.value;

    this.playerService.addPlayer(name, dorsal).subscribe((response) => {
      this.getAllPlayers();
      this.formPlayer.reset();
    });
  }

  deletePlayer(id: number) {
    this.playerService.deletePlayer(id).subscribe((response) => {
      this.getAllPlayers();
    });
  }

  editPlayer() {
    const name = this.formPlayer.get('name')?.value;
    const dorsal = this.formPlayer.get('dorsal')?.value;
    const id = this.editId;

    if (id == null) {
      return console.log('Error, el id no puede ser nulo');
    }

    return this.playerService.editPlayer(id, name, dorsal).subscribe((response) => {
      this.getAllPlayers();
      this.formPlayer.reset();
    });
  }

  ableEdit(player: any, id: number) {
    this.editId = id;
    this.formPlayer.setValue({
      name: player.name,
      dorsal: player.dorsal,
    });
  }
}
