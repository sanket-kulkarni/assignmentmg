package com.example.myGlamm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.myGlamm.model.search.Response;
import com.example.myGlamm.model.search.RestaurantsItem;
import com.example.myGlamm.network.ApiClient;
import com.example.myGlamm.network.NetworkAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class ListActivity extends AppCompatActivity implements RecyclerViewListItem {

    private static final String TAG = "ListActivity";
    RecyclerView recycler_view;
    EditText etSearch;
    ArrayList<RestaurantsItem>responseDataList;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recycler_view = findViewById(R.id.recycler_view);
        responseDataList = new ArrayList<>();
        webServiceToGetList();

    }

    private void initialiseRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_view.setLayoutManager(linearLayoutManager);
        listAdapter = new ListAdapter(this, responseDataList, this);
        recycler_view.setAdapter(listAdapter);
        //rvLanguages.setNestedScrollingEnabled(false);
    }

    /**
     * webService To Get Talukas List
     */
    public void webServiceToGetList() {
        if (isNetworkAvailable(ListActivity.this)) {
            //    final Dialog mDialog = showProgressDialog(ListActivity.this);

            NetworkAPI networkAPI = ApiClient.getClient("https://developers.zomato.com").create(NetworkAPI.class);
            final Call<Response> Response = networkAPI.getData("4feaa2167c4dc6beadf629319423bd4b","0","20","20.013800","73.783748");
            Response.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> jsonElementResponse) {
                    Log.d(TAG, "JsonElement " + jsonElementResponse);
                    if (null == jsonElementResponse.body()) {
                        //mDialog.dismiss();
                        return;
                    }
                    //    mDialog.dismiss();
                    responseDataList.addAll(jsonElementResponse.body().getRestaurants());

                    initialiseRecyclerView();
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {
                    Log.d("asd","failure "+t.getMessage());
                    //    mDialog.dismiss();
                }
            });
        }
    }

    /**
     * To check internet availability
     */
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

//    /**
//     * To show Progress Dialog in Register SureSell form
//     */
//    public static Dialog showProgressDialog(Context context) {
//        final Dialog dialog = new Dialog(context);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//        dialog.setContentView(R.layout.custom_progress_bar);
//        dialog.setCancelable(false);
//
//        ImageView imageView = dialog.findViewById(R.id.ivLoader);
//        Glide.with(context).asGif().load(R.raw.loader_200px).into(imageView);
//        dialog.show();
//        return dialog;
//    }

    @Override
    public void onItemClicked(int position) {

    }
}
