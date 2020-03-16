package com.example.asuno;

import com.example.asuno.Classes.HeadApi;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("head")
    @Expose
    public HeadApi head;

    @SerializedName("body")
    @Expose
    public Object body;

    public HeadApi getHead() {
        return head;
    }

    public void setHead(String what, String sessionId) {
        HeadApi head = new HeadApi();
        head.setWhat(what);
        head.setSessionId(sessionId);
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
