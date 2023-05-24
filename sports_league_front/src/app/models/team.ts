import { player } from "./player";
import {game} from "./game";

export interface team{
  name : string,
  place : string,
  logo : string,
  coach : string,
  players : player[]
  home_games : game[],
  ext_games : game[]
}
