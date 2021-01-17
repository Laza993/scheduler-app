import { TaskService } from './../task.service';
import { Component, OnInit } from '@angular/core';
import { Task } from '../task';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  tasks: Task[];

  constructor(private taskService: TaskService

    ) { this.tasks = []; }

  ngOnInit(): void {
    this.taskService.getTask().subscribe((data: Task[]) => {
      console.log(data);
      this.tasks = data;
    });
  }

  ngDelete(id: number){
    this.taskService.deleteTask(id).subscribe(result => this.ngOnInit());
  }



}
