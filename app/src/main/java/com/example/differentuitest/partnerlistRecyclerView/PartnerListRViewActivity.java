package com.example.differentuitest.partnerlistRecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.differentuitest.R;
import com.example.differentuitest.api.BaseApiService;
import com.example.differentuitest.api.UtilsApi;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.differentuitest.login.LoginActivity2.PREFS_NAME;

public class PartnerListRViewActivity extends AppCompatActivity {

    SharedPreferences settings;
    String access_token;
    List<PartnerListRVModel> modelPartnerList = new ArrayList<>();
    SpinKitView progress;
    NestedScrollView nestedScrollView;

    BaseApiService mApiService;
    Boolean stat;
    int offset = 0, limit = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_list_rview);

        progress = findViewById(R.id.spin_kit);
        nestedScrollView = findViewById(R.id.scroll_viewId);

        mApiService = UtilsApi.getAPIService();
        settings = getSharedPreferences(PREFS_NAME, 0);

        progress.setVisibility(View.VISIBLE);
        partnerList(offset, limit);

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                //check condition
                if(scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    //when reach last item position
                    //increase offset
                    offset = offset + 200;
                    //show progress bar
                    progress.setVisibility(View.VISIBLE);
                    //call method
                    partnerList(offset, limit);
                }
            }
        });

    }


    private void partnerList(int offset, int limit) {
        access_token = settings.getString("access_token", "");
//        int offset = 0;
//        int limit = 6000;

        mApiService.partnerList(access_token, offset, limit).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        stat = (Boolean) jsonObject.get("status");
                        if (stat) {
                            progress.setVisibility(View.GONE);
                            JSONArray jsonArray = jsonObject.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                PartnerListRVModel partnerListModel = new PartnerListRVModel();
                                partnerListModel.setPintId(jsonObject1.getInt("pInt_ID"));
                                partnerListModel.setPartnerId(jsonObject1.getString("partner_ID"));
                                partnerListModel.setPartnerName(jsonObject1.getString("partnerName"));
                                modelPartnerList.add(partnerListModel);

                            }

                            RecyclerView recyclerView = findViewById(R.id.partnerListRVId);
                            PartnerListRVAdapter adapter = new PartnerListRVAdapter(PartnerListRViewActivity.this, modelPartnerList);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(PartnerListRViewActivity.this, LinearLayoutManager.VERTICAL, false));

                            recyclerView.setItemAnimator(new DefaultItemAnimator());

                        } else {
                                Toast.makeText(PartnerListRViewActivity.this, "No partner Name found", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();

                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                } else {
                    Toast.makeText(PartnerListRViewActivity.this, "Partner List error " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "API call failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}