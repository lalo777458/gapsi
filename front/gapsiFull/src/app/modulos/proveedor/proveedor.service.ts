import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proveedor } from 'src/interfaces/proveedor';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  private urlEndPoint: string = 'http://localhost:8080/proveedor/'

  constructor(private http: HttpClient) { }

  getProveedores(): Observable<Proveedor[]> {
    return this.http.get<Proveedor[]>(this.urlEndPoint);
  }

  saveProveedor(proveedor: Proveedor): Observable<any> {
    return this.http.post<any>(this.urlEndPoint, proveedor);
  }

  deleteProveedor(idProveedor: number): Observable<any> {
    let params = new HttpParams().set('idProveedor', idProveedor);
    return this.http.delete(this.urlEndPoint, { params });
  }

}
