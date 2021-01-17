import { TaskService } from './../task.service';
import { Component } from '@angular/core';
import { Task } from '../task';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent{

  task: Task;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private taskService: TaskService) { this.task = new Task(); }

  onSubmit(){
    this.taskService.saveTask(this.task).subscribe(result => this.goToTaskList());

  }

  goToTaskList(){
    this.router.navigate(['/tasks']);
  }
}
