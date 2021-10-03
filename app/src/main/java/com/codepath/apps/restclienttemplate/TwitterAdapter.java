package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.ViewHolder> {
     Context context;
    List<Tweet> tweets;
    public TwitterAdapter(Context context, List<Tweet> tweets){
        this.context=context;
        this.tweets=tweets;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Tweet tweet=tweets.get(position);
        holder.bind(tweet);


    }
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }
    public void addAll(List<Tweet> list) {
        tweets.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProfileImage;
        TextView tvscreenName;
        TextView tvTweet;
        TextView tvtime;
        public ViewHolder(View itemView){
            super(itemView);
            tvscreenName=itemView.findViewById(R.id.tvscreenname);
            tvTweet=itemView.findViewById(R.id.tvTweet);
            ivProfileImage=itemView.findViewById(R.id.ivProfileimage);
            tvtime=itemView.findViewById(R.id.tvtime);
        }

        public void bind(Tweet tweet) {
            tvTweet.setText(tweet.body);
            tvscreenName.setText(tweet.user.screenName);
            tvtime.setText(tweet.formattedTime);
            Glide.with(context).load(tweet.user.profileURL).into(ivProfileImage);

        }
    }

}
