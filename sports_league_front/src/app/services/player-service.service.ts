import { Injectable } from '@angular/core';
import { player } from '../models/player';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Injectable(/*{
  // providedIn: 'root'
}*/)
export class PlayerServiceService {

  constructor(private _httpClient : HttpClient, private _router : Router) { }

  player! : player


  getOne(id : number){
    return this._httpClient.get<player>("http://localhost:8081/player/"+id);
  }

  getAll(){
    return this._httpClient.get<player>("http://localhost:8081/player/all");
  }

  create(p : player){
    return this._httpClient.post<player>("https://localhost:8081/player/create",p);

  }
}
