package com.example.mvvmwithretrofit.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmwithretrofit.model.PostModel;
import com.example.mvvmwithretrofit.network.ApiInterface;
import com.example.mvvmwithretrofit.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListViewModel extends ViewModel {

    private MutableLiveData<List<PostModel>> postsList;

    public PostListViewModel() {
        postsList = new MutableLiveData<>();
    }

    public MutableLiveData<List<PostModel>> getPostsListObserver(){
        return postsList;
    }

    public void makeApiCall(){

        ApiInterface apiInterface = RetrofitClient.getRetrofitClient().create(ApiInterface.class);
        Call<List<PostModel>> call = apiInterface.getPostList();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                postsList.postValue(response.body());

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

                postsList.postValue(null);

            }
        });


    }
}
