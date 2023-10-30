import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomePage } from './home.page';
import { HttpClientModule } from '@angular/common/http';


import { HomePageRoutingModule } from './home-routing.module';
import { PlayersComponent } from '../players/players.component';
import { MatchesComponent } from '../matches/matches.component';
import { TeamsComponent } from '../teams/teams.component';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomePageRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  declarations: [HomePage, PlayersComponent, MatchesComponent, TeamsComponent]
})
export class HomePageModule {}
