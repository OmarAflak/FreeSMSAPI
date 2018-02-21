package me.aflak.libraries;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Omar on 21/02/2018.
 */

public class Data {
    @SerializedName("user") private String  user;
    @SerializedName("pass") private String pass;
    @SerializedName("msg") private String message;

    public Data(String user, String pass, String message) {
        this.user = user;
        this.pass = pass;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getMessage() {
        return message;
    }
}
