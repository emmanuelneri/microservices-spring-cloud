import { Component, OnInit } from '@angular/core';
import {Order} from "./order";
import {OrderService} from "./order.service";
import dataPageUtil from "../dataPageUtil";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  private orders: Order[] = [];
  private page: number = 1;
  private pageSize: number = dataPageUtil.getPageSize();
  private totalElements: number = 0;

  constructor(private orderService: OrderService ) { }

  ngOnInit() {
    this.findOrders();
  }

  private findOrders() {
    this.orderService.findAllPaged(this.page, this.pageSize).subscribe(data => {
      this.orders = data.content;
      this.totalElements = data.totalElements;
    });
  }

  private loadPage(page: number) {
    this.page = page;
    this.findOrders();
  }

}
