package com.example.asuno.Classes.GetSessionId;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SessionJson {

    @SerializedName("head")
    @Expose
    public HeadFromSession head = new HeadFromSession();

    @SerializedName("body")
    @Expose
    public BodyFromSession body;

    public HeadFromSession getHead() {
        return head;
    }

    public void setWhat(String what) {
        //HeadFromSession head = new HeadFromSession();
        //head.setWhat(what);
        this.head.setWhat(what); //= head;
    }

    public BodyFromSession getBody() {
        return body;
    }

    public void setLoginPassword(String login, String password) {
        BodyFromSession bodyFromSession = new BodyFromSession();
        bodyFromSession.setLogin(login);
        bodyFromSession.setPassword(password);

        this.body = bodyFromSession;
    }
}

    class HeadFromSession {

        @SerializedName("what")
        @Expose
        public String what;

        public String getWhat() {
            return what;
        }

        public void setWhat(String what) {
            this.what = what;
        }
    }


