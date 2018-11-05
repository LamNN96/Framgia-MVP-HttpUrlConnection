package com.example.lamnn.todo_mvp.data.resource;


import com.example.lamnn.todo_mvp.data.model.Task;

import java.util.List;

public interface TasksRemoteDataSource {
    void getTasks(Callback<List<Task>> callback);
}
