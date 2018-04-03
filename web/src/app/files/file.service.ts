import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import {environment} from "../../environments/environment";

import { File } from "./file"
import dataPageUtil from "../dataPageUtil";
import {Paged} from "../paged";

@Injectable()
export class FileService {

  private url: string = environment.gatewayUrl + '/files/orders';

  constructor(private httpClient: HttpClient) {}

  findAllPaged(page, pageSize): Observable<Paged<File>> {
    return this.httpClient.get<Paged<File>>(this.url + '/paged/'+ dataPageUtil.getBackEndPage(page) + '/'+ pageSize, {})
  }

  findById(id): Observable<File> {
    return this.httpClient.get<File>(this.url + '/' + id, {})
  }
}
