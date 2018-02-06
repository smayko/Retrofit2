package com.example.nikolakosmajac.retrofit2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nikolakosmajac.retrofit2.R;
import com.example.nikolakosmajac.retrofit2.model.Employee;

import java.util.ArrayList;

/**
 * Created by nikola.kosmajac on 2/2/2018.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>{

    private ArrayList<Employee> datalist;

    public EmployeeAdapter(ArrayList<Employee> datalist) {
        this.datalist = datalist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText(datalist.get(position).getName());
        holder.tvEmail.setText(datalist.get(position).getEmail());
        holder.tvPhone.setText(datalist.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvEmail;
        TextView tvPhone;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_employee_name);
            tvEmail = itemView.findViewById(R.id.txt_employee_email);
            tvPhone = itemView.findViewById(R.id.txt_employee_phone);


        }
    }
}
