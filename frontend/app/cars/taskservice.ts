import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Task} from './task';

@Injectable()
export class TaskService {

    constructor(private http: Http) {}

    getCarsMedium() {
        return this.http.get('http://localhost:9090/api/task')
                    .toPromise()
                    .then(res => <Task[]> res.json())
                    .then(data => { return data; });
    }
}
