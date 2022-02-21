import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {GenericFormField, GenericRecord} from "./generic.model";

@Injectable({
  providedIn: 'root'
})
export class GenericService {
  public BASE ='http://localhost:8080/ui/'
  constructor(private http: HttpClient) {
  }

  findById(entity:string,id: string): Observable<Object[]> {
    const url =`./api/find/${entity}/${id}`
    const params = { 'id': id };
    const headers = new HttpHeaders().set('Accept', 'application/json');
    return this.http.get<Object[]>(this.BASE+url, {params, headers});
  }

  list(entity:string):Observable<Object[]> {
    const url = `./api/list/${entity}`;
    const headers = new HttpHeaders().set('Accept', 'application/json');
    return this.http.get<Object[]>(this.BASE+url, {headers});
  }


  save(entity: string|null,id:string|null, data:Object): Observable<Object> {
    let params = new HttpParams();
    let url = `./api/save/${entity}/${id}`;
    const headers = new HttpHeaders().set('content-type', 'application/json');
    return this.http.post<Object>(this.BASE+url, data, {headers, params});
  }
  saveWithoutId(entity: string|null, data:Object): Observable<Object> {
    let params = new HttpParams();
    let url = `./api/save/${entity}/`;
    const headers = new HttpHeaders().set('content-type', 'application/json');
    return this.http.post<Object>(this.BASE+url, data, {headers, params});
  }

  delete(entity: string,id:string): Observable<Object> {
    let url = `./api/delete/${entity}/${id}`;
    return this.http.delete<Object>(this.BASE+url);
  }

  findAllEntity(): Observable<GenericRecord> {
    const url =`./api/all`
    const headers = new HttpHeaders().set('Accept', 'application/json');
    return this.http.get<GenericRecord>(this.BASE+url, {headers});
  }
  getFormControlByEntity(entity:string|null):Observable<GenericFormField[]>{
    const url =`./api/form/${entity}`
    const headers = new HttpHeaders().set('Accept', 'application/json');
    return this.http.get<GenericFormField[]>(this.BASE+url, {headers});
  }
}
