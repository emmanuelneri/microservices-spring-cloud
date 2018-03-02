import { Injectable } from "@angular/core";

@Injectable()
export class Configuration {

  getUrl(gatewayUrl: string): string {
    return 'http://localhost:9000/api' + gatewayUrl;
  }
}
