import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import {ResultService } from './services/result/result.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
 template: `
<div class="container">
    <div class="input-group" style="margin-top:30px;">
        <input class="form-control mr-1" >
         <span class="input-group-btn">
        <button class="btn btn-primary" (click)="clickMe()">search</button>
        </span>
    </div>
</div>



`
})
export class AppComponent {
  constructor(private router: Router) {}
  msg = "";
  nCnt: number = 0;
  clickMe() {
     this.router.navigateByUrl('https://angular.io/tutorial/toh-pt5');
  }

  
 results = [
    {id: 1, title: 'BTC', citation:'c1'},
    {id: 2, name: 'XRP', citation:'c1'}
    ];
  
}
