import { Injectable } from '@angular/core';
import { Mensaje } from './mensaje';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
export class MensajeService {
  private urlEndPoint: string = 'https://sistemas.forus.cl/forus/challenge/dummy-api/v2/api-docs';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http: HttpClient) { }


  getMensaje() {
    const path = `${this.urlEndPoint}`;
    return this.http.get<Mensaje>(path);
  }
    
  getMensajePost() {
    const path = `${this.urlEndPoint}/paths/producto/get/responses/200/description`;
    return this.http.get<Mensaje>(path);
  }

  /*
  getMensaje(): Observable<Mensaje[]> {
    //return of(CLIENTES);
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Mensaje[])
    );
  }


  create(mensaje: Mensaje) : Observable<Mensaje> {
    return this.http.post<Mensaje>(this.urlEndPoint, mensaje, {headers: this.httpHeaders})
  }

  getCliente(id): Observable<Mensaje>{
    return this.http.get<Mensaje>(`${this.urlEndPoint}/${id}`)
  }

  update(mensaje: Mensaje): Observable<Mensaje>{
    return this.http.put<Mensaje>(`${this.urlEndPoint}/${mensaje.id}`, mensaje, {headers: this.httpHeaders})
  }

  delete(id: number): Observable<Mensaje>{
    return this.http.delete<Mensaje>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
*/
}