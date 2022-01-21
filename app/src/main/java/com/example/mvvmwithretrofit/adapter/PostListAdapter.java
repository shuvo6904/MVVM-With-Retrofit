package com.example.mvvmwithretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmwithretrofit.databinding.SingleRowPostBinding;
import com.example.mvvmwithretrofit.model.PostModel;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {

    Context context;
    List<PostModel> postModelList;

    public PostListAdapter(Context context, List<PostModel> postModelList) {
        this.context = context;
        this.postModelList = postModelList;
    }

    public void setPostModelList(List<PostModel> postModelList){
        this.postModelList = postModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        SingleRowPostBinding singleRowPostBinding = SingleRowPostBinding.inflate(LayoutInflater.from(context), parent, false);
        return new PostViewHolder(singleRowPostBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.setPostList(postModelList.get(position));

    }

    @Override
    public int getItemCount() {
        if (this.postModelList != null){
            return postModelList.size();
        }
        return 0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {


        SingleRowPostBinding singleRowPostBinding;

        public PostViewHolder(@NonNull SingleRowPostBinding singleRowPostBinding) {

            super(singleRowPostBinding.getRoot());

            this.singleRowPostBinding = singleRowPostBinding;

        }

        public void setPostList(PostModel postModel) {

            singleRowPostBinding.titleId.setText(postModel.getTitle());
            singleRowPostBinding.descriptionId.setText(postModel.getBody());

        }
    }
}
