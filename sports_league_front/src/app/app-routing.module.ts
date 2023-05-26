import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventComponent } from './components/event/event.component';
import { PlayerComponent } from './components/player/player.component';
import { TeamComponent } from './components/team/team.component';

const routes: Routes = [
  {path : 'event/:id', component : EventComponent},
  {path : 'player/:id', component : PlayerComponent},
  {path : 'team/:id', component : TeamComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
