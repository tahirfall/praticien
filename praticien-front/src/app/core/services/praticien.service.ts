import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Praticien} from "../models/praticien";
import {environment} from "../../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class PraticienService {
  API_URL = `${environment.apiUrl}/praticiens`;

  constructor(private http: HttpClient) {}

  getPraticiens(): Observable<Praticien[]> {
    return this.http.get<{ content: Praticien[] }>(this.API_URL).pipe(
      map(response => response.content)
    );
  }

  createPraticien(praticien: Praticien): Observable<Praticien> {
    return this.http.post<Praticien>(this.API_URL, praticien);
  }

  updatePraticien(email: string, praticien: Praticien): Observable<Praticien> {
    return this.http.put<Praticien>(`${this.API_URL}/${email}`, praticien);
  }

  deletePraticien(email: string): Observable<void> {
    return this.http.delete<void>(`${this.API_URL}/${email}`);
  }
}
