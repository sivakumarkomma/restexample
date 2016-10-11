import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Task} from './task';

@Injectable()
export class TaskService {

    constructor(private http: Http) {}

    getCarsMedium() {
        return this.http.get('http://localhost/api/task')
                    .toPromise()
                    .then(res => <Task[]> res.json())
                    .then(data => { return data; });
    }

    delete(task: Task) {
        this.http.delete('http://localhost/api/task/'+task.id)
            .toPromise();
    }

    insert(task: Task) {

        let body = JSON.stringify({ task });
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });


        this.http.post('http://localhost/api/task/', body, options)
            .toPromise();
    }

    update(task: Task) {

        let body = JSON.stringify({ task });
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });


        this.http.put('http://localhost/api/task/', body, options)
            .toPromise();
    }

}
