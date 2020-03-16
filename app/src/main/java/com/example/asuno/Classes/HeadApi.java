package com.example.asuno.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeadApi {
    @SerializedName("what")
    @Expose
    public String what;

    @SerializedName("sessionId")
    @Expose
    public String sessionId;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}