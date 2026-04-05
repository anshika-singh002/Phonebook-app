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

        // Make the card clickable!
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Clicked " + deptName, Toast.LENGTH_SHORT).show();
            // Later, this will navigate to a filtered SearchActivity
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