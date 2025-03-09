import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PraticienRoutingModule } from './praticien-routing.module';
import { PraticienComponent } from './praticien.component';
import {MatButton, MatFabButton} from "@angular/material/button";
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";
import {MatCard, MatCardActions, MatCardHeader} from "@angular/material/card";
import {MatFormField} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatInput} from "@angular/material/input";
import {
  MatCell, MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable
} from "@angular/material/table";
import { PraticienUpdateComponent } from './praticien-update/praticien-update.component';


@NgModule({
  declarations: [
    PraticienComponent,
    PraticienUpdateComponent
  ],
  imports: [
    CommonModule,
    PraticienRoutingModule,
    MatButton,
    MatMenu,
    MatMenuItem,
    MatMenuTrigger,
    MatCard,
    MatCardHeader,
    MatCardActions,
    MatFormField,
    MatSelect,
    MatOption,
    MatInput,
    MatTable,
    MatHeaderRow,
    MatRow,
    MatHeaderRowDef,
    MatRowDef,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatCellDef,
    MatHeaderCellDef,
    MatFabButton
  ]
})
export class PraticienModule { }
