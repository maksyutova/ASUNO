package com.example.asuno;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Poll {
    @SerializedName("objectIds")
    @Expose
    public String[] objectIds;

    @SerializedName("what")
    @Expose
    public String what;

    @SerializedName("arg")
    @Expose
    public ArgForPoll arg;

    public void  setPoll1(String[] objectIds, String cmd, String components){
        ArgForPoll arg = new ArgForPoll();
        arg.setCmd(cmd);
        arg.setComponents(components);
        arg.setOnlyHoles(false);
        this.arg = arg;
        this.what = "all";
        this.objectIds = objectIds;
    }

}
class ArgForPoll{
    @SerializedName("cmd")
    @Expose
    public String cmd;

    @SerializedName("components")
    @Expose
    public String components;

    @SerializedName("onlyHoles")
    @Expose
    public Boolean onlyHoles;

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public void setOnlyHoles(Boolean onlyHoles) {
        this.onlyHoles = onlyHoles;
    }

}
