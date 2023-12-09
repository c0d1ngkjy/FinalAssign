package com.example.finalassign;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.bind(task);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTask;
        private CheckBox checkBoxTask;
        private ImageButton btnDeleteTask;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTask = itemView.findViewById(R.id.textViewTask);
            checkBoxTask = itemView.findViewById(R.id.checkBoxTask);
            btnDeleteTask = itemView.findViewById(R.id.btnDeleteTask);

            checkBoxTask.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    textViewTask.setPaintFlags(textViewTask.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    textViewTask.setPaintFlags(textViewTask.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            });

            btnDeleteTask.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    taskList.remove(position);
                    notifyItemRemoved(position);
                }
            });
        }

        public void bind(Task task) {
            textViewTask.setText(task.getTaskName());
            checkBoxTask.setChecked(false);
            textViewTask.setPaintFlags(textViewTask.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }
    }
}
