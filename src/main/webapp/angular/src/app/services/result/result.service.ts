import { Injectable } from '@angular/core';
import { ResultComponent } from '../../components/result/result.component';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable()
export class ResultService {
    results= [
    {id: 1, title: 'BTC', citation:'c1'},
    {id: 2, name: 'XRP', citation:'c1'}
    ];
   constructor ( private http: HttpClient) {}
    private url:string = "http://localhost:8080/results";
    
    public getAll():Observable<ResultComponent[]>{
        return this.http.get<ResultComponent[]>(this.url);
    }
    
     getMyItems()
  {
    return this.results;
  }
  
}

