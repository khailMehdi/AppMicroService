import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-benificiary',
  templateUrl: './benificiary.component.html',
  styleUrl: './benificiary.component.css'
})
export class BenificiaryComponent implements OnInit{
 constructor(private http:HttpClient) {
 }
 ngOnInit() {
   this.http.get("http://localhost:8888/Beneficiarys")
     .subscribe(data=>)
 }
}
