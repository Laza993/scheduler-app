import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskSchedullerComponent } from './task-scheduller.component';

describe('TaskSchedullerComponent', () => {
  let component: TaskSchedullerComponent;
  let fixture: ComponentFixture<TaskSchedullerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskSchedullerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskSchedullerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
