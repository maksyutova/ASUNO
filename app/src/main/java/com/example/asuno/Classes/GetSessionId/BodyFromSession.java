package com.example.asuno.Classes.GetSessionId;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BodyFromSession {

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("password")
    @Expose
    public String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @SerializedName("user")
    @Expose
    public UserFromBodySession user;

    @SerializedName("sessionId")
    @Expose
    public String sessionId;

    @SerializedName("message")
    @Expose
    public String message;


    public UserFromBodySession getUser() {
        return user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getMessage() {
        return message;
    }

}
