package com.example.lamnn.todo_mvp.data.repository;

import com.example.lamnn.todo_mvp.data.model.Task;
import com.example.lamnn.todo_mvp.data.source.Callback;
import com.example.lamnn.todo_mvp.data.source.TasksDataSource;
import com.example.lamnn.todo_mvp.utils.TasksKey;

import java.util.List;

public class TasksRepository implements TasksDataSource {

  private static TasksRepository sInstance;

  public static TasksRepository getInstance() {
    if (sInstance == null) {
      sInstance = new TasksRepository();
    }
    return sInstance;
  }

  @Override
  public void getTasks(Callback<List<Task>> callback) {
    new AsyncTaskTasksContent(callback).execute(TasksKey.URL);
  }
}
