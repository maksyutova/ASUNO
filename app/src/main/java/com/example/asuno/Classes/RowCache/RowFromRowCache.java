package com.example.asuno.Classes.RowCache;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RowFromRowCache {

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("pname")
    @Expose
    public String pname;

    @SerializedName("indication")
    @Expose
    public String indication;

    @SerializedName("indicationUnitMeasurement")
    @Expose
    public String indicationUnitMeasurement;

    @SerializedName("controllerData")
    @Expose
    public String controllerData;

    @SerializedName("event")
    @Expose
    public String event;

    @SerializedName("value")
    @Expose
    public String value;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("date")
    @Expose
    public String date;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPname() {
        return pname;
    }

    public String getIndication() {
        return indication;
    }

    public String getIndicationUnitMeasurement() {
        return indicationUnitMeasurement;
    }

    public String getControllerData() {
        return controllerData;
    }

    public String getEvent() {
        return event;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {return date; }

    public Date getDateDt() {
        Date date1 = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            date1 = formatter.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return date1;
    }

}
