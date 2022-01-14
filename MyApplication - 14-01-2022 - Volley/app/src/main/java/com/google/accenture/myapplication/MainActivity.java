package com.google.accenture.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.accenture.myapplication.modelclasses.Item;
import com.google.accenture.myapplication.modelclasses.SourceData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ProgressBar progressBar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.data);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        editText = findViewById(R.id.editTextTextPersonName);
    }


    public void fetch2Code(View view) {
       /* String q = editText.getText().toString();
        progressBar.setVisibility(View.VISIBLE);

        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BooksService booksService = r.create(BooksService.class);

        Call<SourceData> booksData = booksService.getBooksData(q);

        booksData.enqueue(new Callback<SourceData>() {
            @Override
            public void onResponse(Call<SourceData> call, Response<SourceData> response) {
                progressBar.setVisibility(View.INVISIBLE);
                SourceData s = response.body();
                result.setText("");
                List<Item> items = s.getItems();
                for(int i=0; i<items.size(); i++)
                {
                    String t = items.get(i).getVolumeInfo().getTitle();
                    result.append(t+"\n");
                }

            }

            @Override
            public void onFailure(Call<SourceData> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("MAINACTIVITY", t.getMessage());
            }
        });*/
        /*Retrofit r = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        BooksService booksService = r.create(BooksService.class);
        Call<String> booksData = booksService.getBooksData(q);

        booksData.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressBar.setVisibility(View.INVISIBLE);
                *//*result.setText(response.body());*//*
                result.setText("");
                String jsonData = response.body();
                try {
                    JSONObject root = new JSONObject(jsonData);
                    JSONArray items = root.getJSONArray("items");
                    for(int i=0; i<items.length(); i++){
                        JSONObject dataItem = items.getJSONObject(i);
                        JSONObject volumeInfo = dataItem.getJSONObject("volumeInfo");
                        String title = volumeInfo.getString("title");
                        result.append(title+"\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void fetchCode(View view){
        String q = editText.getText().toString();
        progressBar.setVisibility(View.VISIBLE);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://www.googleapis.com/books/v1/volumes?q="+q;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
    }
}
