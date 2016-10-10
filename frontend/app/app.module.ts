import {NgModule}      from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule}    from '@angular/http';
import {BrowserModule} from '@angular/platform-browser';

import {TaskListComponent}  from './tasks/task-list.component';
import {TaskService} from './tasks/taskservice';
import {InputTextModule,DataTableModule,ButtonModule,DialogModule,CheckboxModule} from 'primeng/primeng';

@NgModule({
  imports:      [BrowserModule,FormsModule,HttpModule,InputTextModule,DataTableModule,ButtonModule,DialogModule,CheckboxModule],
  declarations: [TaskListComponent],
  bootstrap:    [TaskListComponent],
  providers:    [TaskService]
})
export class AppModule { }
