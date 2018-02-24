import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import {environment} from "../../environments/environment";

import { File } from "./file"

@Injectable()
export class FileService {

  private url: string = environment.gatewayUrl + '/files/orders';

  constructor(private httpClient: HttpClient) {}

  findAll(): Observable<File[]> {
    return this.httpClient.get<File[]>(this.url, {})
  }

  findById(id): Observable<File> {
    return this.httpClient.get<File>(this.url + '/' + id, {})
  }
}
