package com.example.mvvmwithretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.mvvmwithretrofit.adapter.PostListAdapter;
import com.example.mvvmwithretrofit.databinding.ActivityMainBinding;
import com.example.mvvmwithretrofit.model.PostModel;
import com.example.mvvmwithretrofit.viewmodel.PostListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    PostListAdapter postListAdapter;
    List<PostModel> postModelList;
    PostListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        postListAdapter = new PostListAdapter(this, postModelList);
        mainBinding.recyclerViewId.setAdapter(postListAdapter);

        viewModel = ViewModelProviders.of(this).get(PostListViewModel.class);
        viewModel.getPostsListObserver().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {

                if (postModels != null){
                    postModelList = postModels;
                    postListAdapter.setPostModelList(postModelList);
                }
                else {
                    Toast.makeText(MainActivity.this, "No Result Found", Toast.LENGTH_SHORT).show();
                }

            }
        });

        viewModel.makeApiCall();
    }

}