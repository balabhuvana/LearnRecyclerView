package com.example.kannan.learnrecyclerview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import adapter.GroceryAdapter;
import adapter.GroceryAdapterDataBinding;
import network.BaseNetworkApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RecyclerViewActivity extends BaseActivity {

    private static String TAG = RecyclerViewActivity.class.getSimpleName();
    private static RecyclerView mRecyclerView;
    private static RecyclerView.LayoutManager mLayoutManager;
    private static GroceryAdapter mGroceryAdapter;
    private static GroceryAdapterDataBinding mGroceryAdapterDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initViews();
        hitFruits();

    }

    public void initViews() {
        try {
            mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
            intiRecyclerView();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

    public void intiRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void setRecyclerViewAdapterValue(List<Fruits> mFruitsList) {
        try {
            mGroceryAdapter = new GroceryAdapter(getApplicationContext(), mFruitsList);
            mRecyclerView.setAdapter(mGroceryAdapter);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void setRecyclerViewAdapterDataBindingValue(List<Fruits> mFruitsList) {
        try {
            mGroceryAdapterDataBinding = new GroceryAdapterDataBinding(getApplicationContext(), mFruitsList);
            mRecyclerView.setAdapter(mGroceryAdapterDataBinding);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void hitFruits() {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://demo0214632.mockable.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            BaseNetworkApi mBaseNetworkApi = retrofit.create(BaseNetworkApi.class);

            Call<FruitList> call = mBaseNetworkApi.getFruits();
            call.enqueue(new Callback<FruitList>() {
                @Override
                public void onResponse(Call<FruitList> call, Response<FruitList> response) {
                    Log.d(TAG, "onResponse");
                    if (response.body().getFruitsList() != null && response.body().getFruitsList().size() > 0) {
                        setRecyclerViewAdapterDataBindingValue(response.body().getFruitsList());
                    } else {
                        Log.d(TAG, "null or size zero");
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
