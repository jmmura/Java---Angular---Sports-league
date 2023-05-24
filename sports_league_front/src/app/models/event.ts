import { team } from "./team";
import {game} from "./game";

export interface event{
  name : string,
  beginning :  Date,
  ending : Date,
  teams : team[],
  games : game[]
}
