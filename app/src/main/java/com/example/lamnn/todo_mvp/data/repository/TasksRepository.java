package com.example.lamnn.todo_mvp.data.repository;

import com.example.lamnn.todo_mvp.data.model.Task;
import com.example.lamnn.todo_mvp.data.resource.Callback;
import com.example.lamnn.todo_mvp.data.resource.TasksRemoteDataSource;
import com.example.lamnn.todo_mvp.utils.TasksKey;

import java.util.List;

public class TasksRepository implements TasksRemoteDataSource {

    private static TasksRepository sInstance;

    public static TasksRepository getInstance() {
        if (sInstance == null) sInstance = new TasksRepository();
        return sInstance;
    }

    @Override
    public void getTasks(Callback<List<Task>> callback) {
        new TasksContent(callback).execute(TasksKey.URL);
    }
}
