import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { OrderService } from "./order.service";
import { Order } from "./order";

@Component({
  selector: 'app-orders-view',
  templateUrl: './orders-view.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersViewComponent implements OnInit {

  private order: Order;

  constructor(private route: ActivatedRoute, private orderService: OrderService) {
    this.order = new Order();
  }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.findById(id);
  }

  private findById(id) {
    this.orderService.findById(id).subscribe(data => {
      this.order = data
    });
  }

}
