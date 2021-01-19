package com.daangnmarket.Service;

import com.daangnmarket.Models.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsApiService {
    String BaseUrl = "https://newsapi.org/v2/";

    @GET("V2/top-headlines")
    List<News> topHeadlines(
            @Query("q") String query,
            @Query("apiKey") String apiKey);

    @GET("everything")
    Call<News> everything(
            @Query("q") String query,
            @Query("apiKey") String apiKey);
}
