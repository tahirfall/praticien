import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PraticienService} from "../core/services/praticien.service";
import {Praticien} from "../core/models/praticien";

@Component({
  selector: 'app-praticien',
  templateUrl: './praticien.component.html',
  styleUrl: './praticien.component.scss'
})
export class PraticienComponent implements OnInit{
  praticiens: Praticien[] = [];
  selectedPraticiens: Praticien[] = [];
  praticien: Praticien = {};

  displayedColumns = ['firstName', 'lastName'];
  constructor(
    private router: Router,
    private praticienService: PraticienService
  ) {}

  ngOnInit() {
    this.loadPraticiens();
  }

  loadPraticiens() {
    this.praticienService.getPraticiens().subscribe(
      (data) => {
        this.praticiens = data;
      },
      (error) => {
        console.error('Error fetching praticiens', error);
        this.praticiens = [];
      }
    );
  }
}
