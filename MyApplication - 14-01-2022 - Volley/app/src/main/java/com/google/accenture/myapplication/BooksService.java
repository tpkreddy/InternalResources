package com.google.accenture.myapplication;

import com.google.accenture.myapplication.modelclasses.SourceData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksService {

    @GET("volumes?")
    Call<SourceData> getBooksData(@Query("q") String query);

}
