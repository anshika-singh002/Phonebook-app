package com.example.viewgroupapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DeptViewHolder> {

    private List<String> departmentList;

    public DepartmentAdapter(List<String> departmentList) {
        this.departmentList = departmentList;
    }

    @NonNull
    @Override
    public DeptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_department, parent, false);
        return new DeptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeptViewHolder holder, int position) {
        String deptName = departmentList.get(position);
        holder.textDeptName.setText(deptName);

        // Make the card clickable and navigate!
        holder.itemView.setOnClickListener(v -> {
            // Get the context (needed to start a new screen)
            android.content.Context context = v.getContext();

            if (deptName.equals("Emergency Contacts")) {
                // 1. If they click Emergency, go to the Emergency screen
                android.content.Intent intent = new android.content.Intent(context, EmergencyActivity.class);
                context.startActivity(intent);
            } else {
                // 2. If they click a normal department, go to the Search screen
                android.content.Intent intent = new android.content.Intent(context, SearchActivity.class);
                // We pass the name of the department so the search screen knows what to filter later!
                intent.putExtra("DEPARTMENT_NAME", deptName);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return departmentList.size();
    }

    public static class DeptViewHolder extends RecyclerView.ViewHolder {
        TextView textDeptName;

        public DeptViewHolder(@NonNull View itemView) {
            super(itemView);
            textDeptName = itemView.findViewById(R.id.textDeptName);
        }
    }
}