package com.example.lamnn.todo_mvp.data.source;

import com.example.lamnn.todo_mvp.data.model.Task;

import java.util.List;

public interface TasksDataSource {
    interface GetDataCallback {
        void getDataSuccess(List<Task> tasks);

        void getDataFail(Exception e);
    }

    void getTasks(GetDataCallback callback);
}
