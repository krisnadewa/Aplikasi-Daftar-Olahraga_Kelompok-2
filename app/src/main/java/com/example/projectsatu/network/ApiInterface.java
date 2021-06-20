package com.example.projectsatu.network;

import com.example.projectsatu.data.ListSports;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
        @GET("all_sports.php")
        Call<ListSports> getSports();
    }