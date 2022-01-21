package com.example.mvvmwithretrofit.network;

import com.example.mvvmwithretrofit.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<PostModel>> getPostList();
}
