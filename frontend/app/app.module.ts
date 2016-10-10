import {NgModule}      from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule}    from '@angular/http';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent}  from './app.component';
import {TaskService} from './tasks/taskservice';
import {InputTextModule,DataTableModule,ButtonModule,DialogModule,CheckboxModule} from 'primeng/primeng';

@NgModule({
  imports:      [BrowserModule,FormsModule,HttpModule,InputTextModule,DataTableModule,ButtonModule,DialogModule,CheckboxModule],
  declarations: [AppComponent],
  bootstrap:    [AppComponent],
  providers:    [TaskService]
})
export class AppModule { }
