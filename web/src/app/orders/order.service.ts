import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import { environment } from '../../environments/environment';

import {Order} from "./order";
import {Paged} from "../paged";
import dataPageUtil from "../dataPageUtil";

@Injectable()
export class OrderService {

  private url: string = environment.gatewayUrl + '/orders';

  constructor(private httpClient: HttpClient) {}

  findAllPaged(page, pageSize): Observable<Paged<Order>> {
    return this.httpClient.get<Paged<Order>>(this.url + '/paged/'+ dataPageUtil.getBackEndPage(page) + '/'+ pageSize, {})
  }

  findById(id): Observable<Order> {
    return this.httpClient.get<Order>(this.url + '/' + id, {})
  }
}
