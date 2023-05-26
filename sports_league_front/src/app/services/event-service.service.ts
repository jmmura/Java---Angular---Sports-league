import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { event } from '../models/event';

@Injectable({
  providedIn: 'root'
})
export class EventServiceService {

  constructor(private _httpClient : HttpClient) { }


  getOne(id : number){
    return this._httpClient.get<event>("http://localhost:8081/event/"+id);
  }

  getAll(){
    return this._httpClient.get<event>("http://localhost:8081/event/all");
  }
}
