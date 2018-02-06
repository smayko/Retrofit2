package com.example.nikolakosmajac.retrofit2.network;

import com.example.nikolakosmajac.retrofit2.model.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nikola.kosmajac on 2/2/2018.
 */

public interface GetEmployeeDataService {

    @GET("retrofit-demo.php")
    Call<EmployeeList> getEmployeeData(@Query("company_no") int companyNo);
}
