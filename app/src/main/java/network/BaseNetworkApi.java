package network;

import java.util.ArrayList;

import model.FruitList;
import model.Fruits;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by balamurugan_se on 6/9/2016.
 */
public interface BaseNetworkApi {

    @GET("/fruits")
    Call<ArrayList<Fruits>> getUser();

    @GET("/fruits")
    Call<FruitList> getFruits();
}
