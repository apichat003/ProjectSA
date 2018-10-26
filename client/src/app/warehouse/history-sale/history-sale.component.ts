import { Component, OnInit } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import dateformat from 'dateformat';
export interface PeriodicElement {
  receiptID:String;
  name: string;
  itemName:string;
  amount: number;
  time: Date;
  date: Date;
  total:number;
}

@Component({
  selector: 'app-history-sale',
  templateUrl: './history-sale.component.html',
  styleUrls: ['./history-sale.component.css']
})
export class HistorySaleComponent implements OnInit {

  
  displayedColumns: string[] = ['receiptID' ,'name', 'itemName', 'amount', 'date', 'time','total'];
  dataSource;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    const ELEMENT_DATA: PeriodicElement[] = [];
   

    
    this.http.get("http://localhost:8080/history").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          ELEMENT_DATA.push({
            receiptID: data[index].receiptID.name,
            name: data[index].user.userName,
            itemName: data[index].item.itemName,
            amount: data[index].amount,
            total: data[index].total,
            time: dateformat( new Date(data[index].date), "h:MM:ss TT"),
            date: dateformat( new Date(data[index].date), "dd mmmm yyyy")
          })


        }
        //console.log(ELEMENT_DATA);
        this.dataSource = ELEMENT_DATA;
      },
      error => {
        console.log("Error", error);
      }

    );
  }

}
