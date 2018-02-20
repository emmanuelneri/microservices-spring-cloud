import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import {FilesComponent} from "./files/files.component";
import {OrdersComponent} from "./orders/orders.component";
import {FilesViewComponent} from "./files/files-view.component";
import {OrdersViewComponent} from "./orders/orders-view.component";
import {DashboardComponent} from "./dashboard/dashboard.component";

@NgModule({
  exports: [ RouterModule ],
  imports: [
    RouterModule.forRoot([
      { path: '', component: DashboardComponent },
      { path: 'files', component: FilesComponent },
      { path: 'files/:id', component: FilesViewComponent },
      { path: 'orders', component: OrdersComponent },
      { path: 'orders/:id', component: OrdersViewComponent },
    ])
  ]
})
export class AppRoutingModule {}
