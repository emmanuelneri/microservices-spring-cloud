import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { FilesComponent } from './files/files.component';
import { FilesViewComponent } from './files/files-view.component';
import { OrdersComponent } from './orders/orders.component';

import { FileService } from './files/file.service';
import { OrdersViewComponent } from './orders/orders-view.component';
import { OrderService } from "./orders/order.service";
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    FilesComponent,
    OrdersComponent,
    FilesViewComponent,
    OrdersViewComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule.forRoot()
  ],
  providers: [FileService, OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
