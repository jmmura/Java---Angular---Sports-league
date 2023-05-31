import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {team, teams} from '../models/team';

@Injectable({
  providedIn: 'root'
})
export class TeamServiceService {

  constructor(private _httpClient : HttpClient) {}

  getAll(){
    return this._httpClient.get<teams>("http://localhost:8081/team/all");
  }

}
