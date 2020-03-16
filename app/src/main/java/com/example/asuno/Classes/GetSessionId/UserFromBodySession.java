package com.example.asuno.Classes.GetSessionId;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserFromBodySession {
    @SerializedName("isAdmin")
    @Expose
    public String isAdmin;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("login")
    @Expose
    public String login;

    public String getIsAdmin() {
        return isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }
}
