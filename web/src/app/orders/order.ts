import {Customer} from "./customer";

export class Order {

  id: number;
  identifier: string;
  customer: Customer;
  dateTime: Date;
  total: number;

  constructor() {
    this.customer = new Customer();
  }
}
