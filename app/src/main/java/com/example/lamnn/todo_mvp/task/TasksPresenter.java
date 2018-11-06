package com.example.lamnn.todo_mvp.task;

import com.example.lamnn.todo_mvp.data.model.Task;
import com.example.lamnn.todo_mvp.data.repository.TasksRepository;

import com.example.lamnn.todo_mvp.data.source.TasksDataSource;
import java.util.ArrayList;
import java.util.List;

public class TasksPresenter implements TasksContract.Presenter {

    private TasksContract.View mView;
    private TasksRepository mTasksRepository;

    public TasksPresenter(TasksContract.View mView, TasksRepository mTasksRepository) {
        this.mView = mView;
        this.mTasksRepository = mTasksRepository;
    }

    @Override
    public void loadTasks(final TasksType tasksType) {
        mTasksRepository.getTasks(new TasksDataSource.GetDataCallback () {
            @Override
            public void getDataSuccess(List<Task> tasks) {
                switch (tasksType) {
                    case ACTIVE_TASKS:
                        mView.showTasks(filterTasks(tasks, TasksType.ACTIVE_TASKS));
                        break;
                    case COMPLETED_TASKS:
                        mView.showTasks(filterTasks(tasks, TasksType.COMPLETED_TASKS));
                        break;
                    default:
                        mView.showTasks(tasks);
                        break;
                }
            }

            @Override
            public void getDataFail(Exception e) {
                mView.showViewFail(e);
            }
        });
    }

    private List<Task> filterTasks(List<Task> tasks, TasksType tasksType) {
        List<Task> completedTasks = new ArrayList<>();
        List<Task> activeTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == true) {
                completedTasks.add(task);
            } else {
                activeTasks.add(task);
            }
        }
        if (tasksType == TasksType.ACTIVE_TASKS) {
            return activeTasks;
        } else {
            return completedTasks;
        }
    }
}
