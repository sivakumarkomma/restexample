import {Component} from '@angular/core';
import {Task} from './cars/task';
import {TaskService} from './cars/taskservice';

class PrimeTask implements Task {

    constructor(public id?, public title?, public details?, public done?) {}
}

@Component({
	templateUrl: './app/app.component.html',
	selector: 'my-app'
})
export class AppComponent {

	displayDialog: boolean;

    task: Task = new PrimeTask();

    selectedTask: Task;

    newTask: boolean;

    tasks: Task[];

    constructor(private taskService: TaskService) { }

    ngOnInit() {
        this.taskService.getCarsMedium().then(tasks => this.tasks = tasks);
    }

    showDialogToAdd() {
        this.newTask = true;
        this.task= new PrimeTask();
        this.displayDialog = true;
    }

    save() {
        if(this.newTask)
            this.tasks.push(this.task);
        else
            this.tasks[this.findSelectedCarIndex()] = this.task;

        this.task = null;
        this.displayDialog = false;
    }

    delete() {
        this.taskService.delete(this.task);
        this.tasks.splice(this.findSelectedCarIndex(), 1);
        this.task = null;
        this.displayDialog = false;
    }

    onRowSelect(event) {
        this.newTask = false;
        this.task = this.cloneCar(event.data);
        this.displayDialog = true;
    }

    cloneCar(t: Task): Task {
        let task = new PrimeTask();
        for(let prop in t) {
            task[prop] = t[prop];
        }
        return task;
    }

    findSelectedCarIndex(): number {
        return this.tasks.indexOf(this.selectedTask);
    }
}
