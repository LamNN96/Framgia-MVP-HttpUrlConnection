package com.example.lamnn.todo_mvp.task;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.lamnn.todo_mvp.R;
import com.example.lamnn.todo_mvp.data.model.Task;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private List<Task> mTasks;
    private OnTaskItemClickListener mOnTaskItemClick;
    private LayoutInflater mInflater;
    private Context mContext;
    private Task mTask;

    public TasksAdapter(List<Task> tasks,
            OnTaskItemClickListener onTaskItemClick) {
        mTasks = tasks;
        mOnTaskItemClick = onTaskItemClick;
    }

    public TasksAdapter(
            OnTaskItemClickListener onTaskItemClick) {
        mOnTaskItemClick = onTaskItemClick;
    }

    public void addData(List<Task> tasks) {
        if (tasks != null) {
            mTasks.addAll(tasks);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        mContext = viewGroup.getContext();
        View view = mInflater.inflate(R.layout.item_task, viewGroup, false);
        return new TasksViewHolder(mContext, view, mOnTaskItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder tasksViewHolder, int i) {
        tasksViewHolder.bindData(mTasks.get(i));
    }

    @Override
    public int getItemCount() {
        return mTasks != null ? mTasks.size() : 0;
    }

    static class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextTitle;
        private CheckBox mCheckBox;
        private OnTaskItemClickListener mListener;
        private Task mTask;

        TasksViewHolder(Context context, @NonNull View itemView, OnTaskItemClickListener listener) {
            super(itemView);
            mListener = listener;
            mTextTitle = itemView.findViewById(R.id.text_title_task);
            mCheckBox = itemView.findViewById(R.id.check_task);
            mTextTitle.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onTaskItemClick(mTask);
        }

        void bindData(final Task task) {
            if (task == null) return;
            mTask = task;
            mTextTitle.setText(task.getTitle());
            mCheckBox.setChecked(task.isCompleted());
        }
    }

    public interface OnTaskItemClickListener {
        void onTaskItemClick(Task task);
    }
}
