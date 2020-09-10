package com.example.techtrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

        final Call<List<OurDataSet>> listCall = ourRetrofit.getDataSet();

        listCall.enqueue(new Callback<List<OurDataSet>>() {
            @Override
            public void onResponse(Call<List<OurDataSet>> call, Response<List<OurDataSet>> response)
            {

                        ShowIt(response.body());

            }

            @Override
            public void onFailure(Call<List<OurDataSet>> call, Throwable t)
            {

            }
        });
    }

    private void ShowIt(List<OurDataSet> response)
    {

        DataAdapter dataAdapter=new DataAdapter(response,getApplicationContext());
        recyclerView.setAdapter(dataAdapter);
    }
}
