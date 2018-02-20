import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";

import { File } from "./file"

@Injectable()
export class FileService {

  private url: string = 'http://localhost:8090/orders/files';

  constructor(private httpClient: HttpClient) {}

  findAll(): Observable<File[]> {
    return this.httpClient.get<File[]>(this.url, {})
  }

  findById(id): Observable<File> {
    return this.httpClient.get<File>(this.url + '/' + id, {})
  }
}
