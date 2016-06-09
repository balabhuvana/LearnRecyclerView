package com.example.kannan.learnrecyclerview;

import android.os.Bundle;
import android.util.Log;

import model.FruitList;
import model.Fruits;
import model.StackOverflowQuestions;
import network.BaseNetworkApi;
import network.StackOverflowAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RecyclerViewActivity extends BaseActivity {

    private static BaseNetworkApi mBaseNetworkApi;
    private String TAG = RecyclerViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        hitFruits();

    }


    public void tryTwo() {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.stackexchange.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // prepare call in Retrofit 2.0
            StackOverflowAPI stackOverflowAPI = retrofit.create(StackOverflowAPI.class);

            Call<StackOverflowQuestions> call = stackOverflowAPI.loadQuestions("android");
            //asynchronous call
            call.enqueue(new Callback<StackOverflowQuestions>() {
                @Override
                public void onResponse(Call<StackOverflowQuestions> call, Response<StackOverflowQuestions> response) {
                    Log.d(TAG, "onResponse");

                }

                @Override
                public void onFailure(Call<StackOverflowQuestions> call, Throwable t) {
                    Log.d(TAG, "onFailure");
                }
            });
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void hitFruits() {


        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://demo7146441.mockable.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            BaseNetworkApi mBaseNetworkApi = retrofit.create(BaseNetworkApi.class);

            Call<FruitList> call = mBaseNetworkApi.getFruits();
            call.enqueue(new Callback<FruitList>() {
                @Override
                public void onResponse(Call<FruitList> call, Response<FruitList> response) {
                    Log.d(TAG, "onResponse");
                    for (Fruits mFruits : response.body().getFruitsList()) {
                        Log.d(TAG, "" + mFruits.getFruitName());
                    }
                }

                @Override
                public void onFailure(Call<FruitList> call, Throwable t) {
                    Log.d(TAG, "onFailure " + t.getMessage());
                }
            });

        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

}
