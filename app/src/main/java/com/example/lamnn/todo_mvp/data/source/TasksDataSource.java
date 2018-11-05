package com.example.lamnn.todo_mvp.data.source;

import com.example.lamnn.todo_mvp.data.model.Task;

import java.util.List;

public interface TasksDataSource {
  void getTasks(Callback<List<Task>> callback);
}
