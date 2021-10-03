package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    public  String body ;
    public  String createdAt;
public  Users user;
    public String formattedTime;
    public String formattedAbsoluteTime;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
    Tweet tweet=new Tweet();
    tweet.body=jsonObject.getString("text");
    tweet.createdAt=jsonObject.getString("created_at");
    tweet.formattedTime = TimeFormatter.getTimeDifference(tweet.createdAt);
    tweet.formattedAbsoluteTime = TimeFormatter.getTimeStamp(tweet.formattedTime);
    tweet.user=Users.fromJson(jsonObject.getJSONObject("user"));
return tweet;
}
public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
    List<Tweet> tweetList = new ArrayList<>();
    for (int i = 0; i < jsonArray.length(); i++) {
        tweetList.add(fromJson(jsonArray.getJSONObject(i)));
    }

return tweetList;
}
}
