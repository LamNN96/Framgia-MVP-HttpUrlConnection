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

import java.util.ArrayList;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private List<Task> mTasks;
    private OnTaskItemClickListener mOnTaskItemClick;
    private LayoutInflater mInflater;
    private Task mTask;

    public TasksAdapter(OnTaskItemClickListener mOnTaskItemClick) {
        mTasks = new ArrayList<>();
        this.mOnTaskItemClick = mOnTaskItemClick;
    }

    public void addData(List<Task> tasks) {
        mTasks.addAll(tasks);
        notifyItemRangeChanged(0, mTasks.size());
    }


    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mInflater == null) mInflater = LayoutInflater.from(viewGroup.getContext());
        Context context = viewGroup.getContext();
        View view = mInflater.inflate(R.layout.item_task, viewGroup, false);
        return new TasksViewHolder(context, view, mOnTaskItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder tasksViewHolder, int i) {
        tasksViewHolder.bindData(mTasks.get(i));
    }

    @Override
    public int getItemCount() {
        return mTasks != null ? mTasks.size() : 0;
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextTitle;
        private CheckBox mCheckBox;
        private OnTaskItemClickListener mListener;
        private Context mContext;
        private Task mTask;

        TasksViewHolder(Context context, @NonNull View itemView, OnTaskItemClickListener listener) {
            super(itemView);
            mContext = context;
            mListener = listener;
            mContext = context;
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
            mTextTitle.setText(task.getmTitle());
            mCheckBox.setChecked(task.ismCompleted());
        }
    }

    public interface OnTaskItemClickListener {
        void onTaskItemClick(Task task);
    }

}
