import {Component, OnInit} from '@angular/core';
import {PlayerServiceService} from "../../services/player-service.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {player} from "../../models/player";

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent {

  players! : player[]
  constructor(private _playerService : PlayerServiceService, private _formBuilder : FormBuilder ) {
  }

  createForm : FormGroup = this._formBuilder.group({
    firstName : ['', [Validators.required]],
    lastName : ['', [Validators.required]],
    number : [0, [Validators.required, Validators.min(0)]],
    picture : ['']
  })

  submit(){
    this._playerService.create(this.createForm.value)
  }



}
