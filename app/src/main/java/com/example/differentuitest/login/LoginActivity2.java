package com.example.differentuitest.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.differentuitest.R;
import com.example.differentuitest.api.BaseApiService;
import com.example.differentuitest.api.UtilsApi;
import com.example.differentuitest.partnerlistRecyclerView.PartnerListRViewActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity2 extends AppCompatActivity {

    EditText userId, passId;
    TextView login;

    public static String PREFS_NAME = "LoginPrefs";
    public static String USER_ID = "id";
    BaseApiService mApiService;
    SharedPreferences settings;

    String token;
    boolean stat;
    String uId, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        userId = findViewById(R.id.userNameInputId);
        passId = findViewById(R.id.passId);
        login = findViewById(R.id.loginBtnId);

        mApiService = UtilsApi.getAPIService();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uId = userId.getText().toString().trim();
                password = passId.getText().toString().trim();

                if (!TextUtils.isEmpty(uId) && !TextUtils.isEmpty(password)) {

                    login(uId, password);

                } else {
                    Toast.makeText(LoginActivity2.this, "Please give Id and password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void login(String uId, String password) {

        mApiService.bondhonLogin(uId, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("token") != "null") {
                            token = (String) jsonObject.get("token");

                            String access_token = "Bearer " + token;

                            settings = getSharedPreferences(PREFS_NAME, 0);
                            SharedPreferences.Editor editor = settings.edit();

                            editor.putString("access_token", access_token);
//                            editor.putString("password", password);
//                            editor.putString("todayDate", formattedDate);
                            editor.apply();


                            Intent i = new Intent(LoginActivity2.this, PartnerListRViewActivity.class);
                            startActivity(i);
                            finish();
                        } else {

                            Toast.makeText(LoginActivity2.this, "Please give Valid UserId and Password", Toast.LENGTH_SHORT).show();

                        }

                    } catch (JSONException e) {

                        Toast.makeText(LoginActivity2.this, "Invalid login credentials. Please try again", Toast.LENGTH_LONG).show();
                        e.printStackTrace();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {

                    Toast.makeText(LoginActivity2.this, "Please Check your internet connection", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.e("debug", "onFailure: ERROR > " + t.toString());
                Toast.makeText(LoginActivity2.this, "Failure login credentials. Please try again", Toast.LENGTH_LONG).show();
            }
        });

    }
}