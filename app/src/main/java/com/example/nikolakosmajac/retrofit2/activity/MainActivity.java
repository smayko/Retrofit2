package com.example.nikolakosmajac.retrofit2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.nikolakosmajac.retrofit2.R;
import com.example.nikolakosmajac.retrofit2.adapter.EmployeeAdapter;
import com.example.nikolakosmajac.retrofit2.model.Employee;
import com.example.nikolakosmajac.retrofit2.model.EmployeeList;
import com.example.nikolakosmajac.retrofit2.network.GetEmployeeDataService;
import com.example.nikolakosmajac.retrofit2.network.RetrofitInstance;
import okhttp3.logging.HttpLoggingInterceptor;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final long READ_TIMEOUT = 50000;
    private static final long CONNECT_TIMEOUT = 50000;
    private EmployeeAdapter adapter;
    private RecyclerView recyclerView;
    private HttpLoggingInterceptor logging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Create handle for the RetrofitInstance interface*/
        GetEmployeeDataService service = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);

        /* Call Method with parameter in the interface to get employee data*/
        Call<EmployeeList> call = service.getEmployeeData(100);

        /*Log URL called */
        Log.wtf("URL_CALLED", call.request().url() + "");  //Log.wtf() will log an error with priority level ASSERT, and may (depending on the system configuration) send an error report and terminate the program immediately.

       // setLogLevel(RestAdapter.LogLevel.FULL);
        logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                if(response.body() != null){
                    generateEmployeeList(response.body().getEmployeeList());
                }
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }


    /*Method to generate List of employees using RecyclerView with custom adapter*/
    public void generateEmployeeList(ArrayList<Employee> empdataList) {

        recyclerView = findViewById(R.id.recycler_view_employee_list);
        adapter = new EmployeeAdapter(empdataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
