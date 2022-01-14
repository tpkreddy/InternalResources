package com.google.accenture.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
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


    public void fetchCode(View view) {
        String q = editText.getText().toString();
        progressBar.setVisibility(View.VISIBLE);
        Retrofit r = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        BooksService booksService = r.create(BooksService.class);
        Call<String> booksData = booksService.getBooksData(q);

        booksData.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressBar.setVisibility(View.INVISIBLE);
                /*result.setText(response.body());*/
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
        });
    }
}
