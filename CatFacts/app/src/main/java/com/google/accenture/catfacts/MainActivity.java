package com.google.accenture.catfacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 1: Create a OkHttp Client object
        OkHttpClient client = new OkHttpClient();
        //TODO 2: Create a Request object
        Request get = new Request.Builder()
                .url("https://cat-fact.herokuapp.com/facts")
                .build();

        //TODO 3: use enqueue method to pass request
        client.newCall(get).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String body = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(MainActivity.this, body, Toast.LENGTH_SHORT).show();
                        Log.d("MAIN", body);

                    }
                });

            }
        });

    }
}