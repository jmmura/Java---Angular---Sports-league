import { Injectable } from '@angular/core';
import { player } from '../models/player';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PlayerServiceService {

  constructor(private _httpClient : HttpClient) { }

  player! : player


  getOne(id : number){
    return this._httpClient.get<player>("http://localhost:8081/player/"+id);
  }
}
