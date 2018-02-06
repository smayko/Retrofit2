package com.example.nikolakosmajac.retrofit2.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nikola.kosmajac on 2/2/2018.
 */

public class EmployeeList {

    @SerializedName("employeeList")
    private ArrayList<Employee> employeeList;


    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employeeList = employees;
    }
}
