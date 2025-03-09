import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PraticienComponent} from "./praticien/praticien.component";

const routes: Routes = [
  {
    path: 'praticien',
    component: PraticienComponent,
    children: [
      {
        path: '',
        loadChildren: () => import('./praticien/praticien.module').then((m) => m.PraticienModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
