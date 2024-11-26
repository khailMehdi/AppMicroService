import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BenificiaryComponent} from "./benificiary/benificiary.component";
import {VirmentComponent} from "./virment/virment.component";

const routes: Routes = [
  {path : "benificiary" ,component :BenificiaryComponent},
  {path :"virment" ,component :VirmentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
