package com.google.accenture.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksService {

    @GET("volumes?")
    Call<String> getBooksData(@Query("q") String query);

}
