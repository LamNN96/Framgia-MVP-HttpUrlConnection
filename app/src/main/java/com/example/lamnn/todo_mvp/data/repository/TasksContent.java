package com.example.lamnn.todo_mvp.data.repository;

import android.os.AsyncTask;

import com.example.lamnn.todo_mvp.data.model.Task;
import com.example.lamnn.todo_mvp.data.resource.Callback;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class TasksContent extends AsyncTask<String, Void, List<Task>> {
    private Callback<List<Task>> mCallback;
    private Exception mException;

    public TasksContent(Callback<List<Task>> mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    protected List<Task> doInBackground(String... strings) {

        List<Task> tasks = new ArrayList<>();
        try {
            TasksDataAPI tasksDataAPI = new TasksDataAPI();
            String json = tasksDataAPI.getTasks(strings[0]);
            tasks = tasksDataAPI.getTaskData(json);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    protected void onPostExecute(List<Task> tasks) {
        super.onPostExecute(tasks);
        if (mCallback == null) return;
        if (mException == null) mCallback.getDataSuccess(tasks);
        else mCallback.getDataFail(mException);
    }
}
