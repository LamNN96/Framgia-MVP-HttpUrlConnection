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

public class TasksActivity extends AppCompatActivity
        implements TasksContract.View, TasksAdapter.OnTaskItemClickListener, View.OnClickListener {
    TasksContract.Presenter mPresenter;
    TasksAdapter mAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        initView();
        loadData();
    }

    private void initView() {
        Button buttonAllTasks = findViewById(R.id.button_all);
        buttonAllTasks.setOnClickListener(this);

        Button buttonActiveTasks = findViewById(R.id.button_active);
        buttonActiveTasks.setOnClickListener(this);

        Button buttonCompletedTasks = findViewById(R.id.button_completed);
        buttonCompletedTasks.setOnClickListener(this);

        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    public void loadData() {
        mPresenter = new TasksPresenter(this, TasksRepository.getInstance());
        mPresenter.loadTasks(TasksType.ALL_TASKS);
    }

    @Override
    public void showTasks(List<Task> tasks) {
        mAdapter = new TasksAdapter(tasks, this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showViewFail(Exception e) {
        Toast.makeText(getApplicationContext(), getString(R.string.error_show_tasks),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTaskItemClick(Task task) {
        Toast.makeText(getApplicationContext(), task.getId() + "", Toast.LENGTH_SHORT).show();
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_active:
                mPresenter.loadTasks(TasksType.ACTIVE_TASKS);
                break;
            case R.id.button_completed:
                mPresenter.loadTasks(TasksType.COMPLETED_TASKS);
                break;
            default:
                mPresenter.loadTasks(TasksType.ALL_TASKS);
                break;
        }
    }
}