import { Injectable } from '@angular/core';
import {environment} from "../../environment/environment";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Speciality} from "../models/speciality";

@Injectable({
  providedIn: 'root'
})
export class SpecialityService {
  API_URL = `${environment.apiUrl}/specialities`;

  constructor(private http: HttpClient) {}

  getSpecialities(): Observable<Speciality[]> {
    return this.http.get<{ content: Speciality[] }>(this.API_URL).pipe(
      map(response => response.content)
    );
  }

  createSpeciality(speciality: Speciality): Observable<Speciality> {
    return this.http.post<Speciality>(this.API_URL, speciality);
  }

  updateSpeciality(name: string, speciality: Speciality): Observable<Speciality> {
    return this.http.put<Speciality>(`${this.API_URL}/${name}`, speciality);
  }

  deleteSpeciality(name: string): Observable<void> {
    return this.http.delete<void>(`${this.API_URL}/${name}`);
  }
}
