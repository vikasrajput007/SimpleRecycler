package com.android.developer.simplerecycler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.developer.simplerecycler.adapter.MessagesAdapter;
import com.android.developer.simplerecycler.model.Asts;
import com.android.developer.simplerecycler.model.Model;
import com.android.developer.simplerecycler.model.ModelArray;
import com.android.developer.simplerecycler.model.RootModel;
import com.android.developer.simplerecycler.network.ApiClient;
import com.android.developer.simplerecycler.network.ApiInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private List<Model> messages = new ArrayList<>();
    private RecyclerView recyclerView;
    private MessagesAdapter mAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ModelArray modelArrays;
    private Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        modelArrays = new ModelArray();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);


        swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {

                        getData();

                    }
                });
    }

    /**
     * to get the server data using retrofit and gson making http request
     *
     * @param
     * @return
     */

    private void getData() {
        swipeRefreshLayout.setRefreshing(true);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<RootModel> call = apiInterface.getModel();
        call.enqueue(new Callback<RootModel>() {

            @Override
            public void onResponse(Call<RootModel> call, Response<RootModel> response) {
                // fetch json using array and getter setter
                System.out.println("error of parsing json :  " );
                try {

                    System.out.println("Result of api is :" + response.body().getMessage());

                    modelArrays = response.body().getData();
                    messages = modelArrays.getData();
                    System.out.println("Model array data is :" + messages.size());
                    //List<Asts> astsList = model.getAstsList();

                    mAdapter = new MessagesAdapter(getApplicationContext(), messages);

                    recyclerView.setAdapter(mAdapter);

                    mAdapter.notifyDataSetChanged();



                   // System.out.println("Size of Asts list is :" + astsList.size());
                }catch (Exception e){
                    System.out.println("error of parsing json :  " + e);
                }

                    swipeRefreshLayout.setRefreshing(false);


            }

            @Override
            public void onFailure(Call<RootModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Unable to fetch json: "+t.getMessage());

                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {

        getData();
    }
}
