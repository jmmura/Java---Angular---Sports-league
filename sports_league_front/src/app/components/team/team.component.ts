import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TeamServiceService} from "../../services/team-service.service";
import {team, teams} from "../../models/team";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.scss']
})
export class TeamComponent implements OnInit{


  constructor(private _activatedRoute : ActivatedRoute, private _teamService : TeamServiceService) {
  }

  // teams : team[] = []
  //
  // ngOnInit(): void {
  //   this._teamService.getAll().subscribe(
  //     {
  //       next: (data) => data.forEach((t: team) => this.teams.push(t))
  //     }
  //   );
  // }

  teams! : teams
  ngOnInit() {
    this._teamService.getAll().subscribe(
      {
        next: (data) => this.teams = data
      }
    );
  }

}
