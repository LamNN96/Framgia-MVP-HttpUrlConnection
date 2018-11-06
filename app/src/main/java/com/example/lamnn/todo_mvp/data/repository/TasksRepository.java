package com.example.lamnn.todo_mvp.data.repository;

import com.example.lamnn.todo_mvp.data.source.TasksDataSource;
import com.example.lamnn.todo_mvp.data.source.remote.TaskRemoteDataSource;

public class TasksRepository implements TasksDataSource {

    private static TasksRepository sInstance;

    public static TasksRepository getInstance() {
        if (sInstance == null) {
            sInstance = new TasksRepository();
        }
        return sInstance;
    }

    @Override public void getTasks(GetDataCallback callback) {
        TaskRemoteDataSource taskRemoteDataSource = new TaskRemoteDataSource();
        taskRemoteDataSource.getTasks(callback);
    }
}
