package com.example.lamnn.todo_mvp.data.source.remote;

import com.example.lamnn.todo_mvp.data.repository.TasksContentAsyncTask;
import com.example.lamnn.todo_mvp.data.source.TasksDataSource;
import com.example.lamnn.todo_mvp.utils.TasksKey;

public class TaskRemoteDataSource implements TasksDataSource {
    private static TaskRemoteDataSource sTaskRemoteDataSource;
    public static TaskRemoteDataSource getInstance(){
        if (sTaskRemoteDataSource == null){
            sTaskRemoteDataSource = new TaskRemoteDataSource();
        }
        return sTaskRemoteDataSource;
    }
    @Override public void getTasks(GetDataCallback callback) {
     new TasksContentAsyncTask(callback).execute(TasksKey.URL);
    }
}
