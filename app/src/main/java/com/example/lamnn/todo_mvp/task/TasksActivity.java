package com.example.lamnn.todo_mvp.task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lamnn.todo_mvp.R;
import com.example.lamnn.todo_mvp.data.model.Task;
import com.example.lamnn.todo_mvp.data.repository.TasksRepository;

import java.util.List;

public class TasksActivity extends AppCompatActivity implements TasksContract.View, TasksAdapter.OnTaskItemClickListener {
    TasksContract.Presenter mPresenter;
    TasksAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        initView();
        loadData();
    }

    private void initView() {
        Button buttonAllTasks = findViewById(R.id.button_all);
        buttonAllTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadTasks(TasksType.ALL_TASKS);
            }
        });
        Button buttonActiveTasks = findViewById(R.id.button_active);
        buttonActiveTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadTasks(TasksType.ACTIVE_TASKS);
            }
        });
        Button buttonCompletedTasks = findViewById(R.id.button_completed);
        buttonCompletedTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadTasks(TasksType.COMPLETED_TASKS);
            }
        });

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TasksAdapter(this);
        recycler.setAdapter(mAdapter);

    }

    public void loadData(){
        mPresenter = new TasksPresenter(this, TasksRepository.getInstance());
        mPresenter.loadTasks(TasksType.ALL_TASKS);

    }


    @Override
    public void showTasks(List<Task> tasks) {
        mAdapter.addData(tasks);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showViewFail(Exception e) {
        Toast.makeText(getApplicationContext(), "Load task fail. Check your connection!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onTaskItemClick(Task task) {
        Toast.makeText(getApplicationContext(), task.getmId()+"", Toast.LENGTH_SHORT).show();
    }
}
