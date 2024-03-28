import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lab1 } from './lab1';
import { Test } from './test';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private url = "http://localhost:8080"
  private data: any
  constructor(private http: HttpClient) { }

  getLab1(p0: number, q0: number, x0: number, length: number): Observable<Lab1> {
    return this.http.get<Lab1>(this.url+"/lab1"+"?p0="+p0.toString()+"&q0="+q0.toString()+"&x0="+x0.toString()+"&length="+length.toString())
  }
  getTest(): Observable<Test> {
    return this.http.get<Test>(this.url+"/test");
  }
}
