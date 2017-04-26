package com.android.developer.simplerecycler.network;

import com.android.developer.simplerecycler.model.Asts;
import com.android.developer.simplerecycler.model.Model;
import com.android.developer.simplerecycler.model.ModelArray;
import com.android.developer.simplerecycler.model.RootModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by HP on 13-04-2017.
 */

public interface ApiInterface {

    @GET("/app-dev-test.json")
    public Call<RootModel> getModel();

    @GET("/app-dev-test.json")
    public Call<ModelArray> getModelArray();

    @GET("/app-dev-test.json")
    public void getAstArray();


}
