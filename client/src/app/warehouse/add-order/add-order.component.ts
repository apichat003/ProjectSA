import { Component, OnInit } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient, HttpParams } from '@angular/common/http';
import { log } from 'util';

export interface Transaction {
  item: string;
  cost: number;
  amount: number;
  price: number;
}
@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  categorys = [];

  onClickSubmit(body) {
    console.log(body);

    this.http.post("http://localhost:8080/item/" + "/" + body.item_name + "/" + body.amount, "").subscribe(
      data => {
        console.log("POST Request is successful ", data);
      },
      error => {
        console.log("Error", error);
      }

    );

  }
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.categorys.push(

    )

    this.http.get("http://localhost:8080/category").subscribe(
      body => {
        console.log("GET Request is successful ", body);
        for (let index = 0; index < body["length"]; index++) {
          this.categorys.push({
            value: body[index].id,
            viewValue: body[index].name
          })


        }
        //console.log(ELEMENT_DATA);
      },
      error => {
        console.log("Error", error);
      }

    );
  }

  displayedColumns = ['item','amount','price','cost'];
  transactions: Transaction[] = [
    {item: 'Beach ball',amount: 11,price: 10, cost: 4},
    {item: 'Towel',amount: 12,price: 13, cost: 5},
    {item: 'Frisbee',amount: 13,price: 12, cost: 2},
    {item: 'Sunscreen',amount: 14,price: 14, cost: 4},
    {item: 'Cooler', amount: 15,price: 15,cost: 25},
    {item: 'Swim suit',amount: 16,price: 17, cost: 15},
  ];

  /** Gets the total cost of all transactions. */
  getTotalCost() {
    return this.transactions.map(t => t.cost).reduce((acc, value) => acc + value, 0);
  }

}
