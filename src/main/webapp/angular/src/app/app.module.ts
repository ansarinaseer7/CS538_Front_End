import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ResultComponent } from './components/result/result.component';
import { ResultService } from './services/result/result.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AboutComponent } from './about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [ResultService],
  bootstrap: [AppComponent]
})
export class AppModule { }
