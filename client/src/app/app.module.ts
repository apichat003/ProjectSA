import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule,MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule,MatGridListModule,MatTabsModule,MatSelectModule,MatIconModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import {LayoutModule} from '@angular/cdk/layout';

import { NavbarComponent } from './navbar/navbar.component';
import { AddOrderComponent } from './salenote/add-order/add-order.component';
import { HistorySaleComponent } from './salenote/history-sale/history-sale.component';


const appRoutes: Routes = [
  { path: "" , component: AddOrderComponent },
  { path: "add-order" , component: AddOrderComponent },
  { path: "history-sale" , component: HistorySaleComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AddOrderComponent,
    HistorySaleComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    FormsModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatGridListModule,
    MatTabsModule,
    MatSelectModule,
    MatTableModule,
    MatIconModule,
    FormsModule,
    LayoutModule,
    
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
