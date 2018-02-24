import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import { environment } from '../../environments/environment';

import {Order} from "./order";

@Injectable()
export class OrderService {

  private url: string = environment.gatewayUrl + '/orders';

  constructor(private httpClient: HttpClient) {}

  findAll(): Observable<Order[]> {
    return this.httpClient.get<Order[]>(this.url, {})
  }

  findById(id): Observable<Order> {
    return this.httpClient.get<Order>(this.url + '/' + id, {})
  }
}
