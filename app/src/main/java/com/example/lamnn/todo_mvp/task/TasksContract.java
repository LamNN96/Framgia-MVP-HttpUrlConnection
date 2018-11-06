package com.example.lamnn.todo_mvp.task;

import com.example.lamnn.todo_mvp.data.model.Task;

import java.util.List;

public interface TasksContract {
    interface View {
        void showTasks(List<Task> tasks);

        void showViewFail(Exception e);
    }

    interface Presenter {
        void loadTasks(TasksType tasksType);
    }
}
