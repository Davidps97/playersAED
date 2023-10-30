import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { TeamsComponent } from './teams/teams.component';
import { MatchesComponent } from './matches/matches.component';
import { PlayersComponent } from './players/players.component';


const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  { path: 'players', component: PlayersComponent },
  { path: 'teams', component: TeamsComponent },
  { path: 'matches', component: MatchesComponent },
  { path: '', redirectTo: 'players', pathMatch: 'full' },
  { path: '**', redirectTo: 'players' },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
