import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from './task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private baseUrl = 'http://localhost:8080/api/tasks/';


  constructor(private http: HttpClient) { }

  getTask(): Observable<Task[]>{
    return this.http.get<Task[]>(`${this.baseUrl}`);
  }

  saveTask(task: Task){
    return this.http.post<Task>(this.baseUrl, task);
  }

  deleteTask(id: number){
    return this.http.delete<Task>(this.baseUrl + id + '/');
  }

}
