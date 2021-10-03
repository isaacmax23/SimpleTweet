package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Users {
    public String name,screenName,profileURL;
    public static Users fromJson(JSONObject jsonObject ) throws JSONException {
        Users user=new Users();

        user.name=jsonObject.getString("name");
        user.screenName=jsonObject.getString("screen_name");
        user.profileURL=jsonObject.getString("profile_image_url_https");
        return user;

    }
}
