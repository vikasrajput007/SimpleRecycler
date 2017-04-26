package com.android.developer.simplerecycler.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by HP on 13-04-2017.
 */

public class Model {

    @SerializedName("schedule_title")
    @Expose
    private String schedule_title;
    @SerializedName("time_start")
    @Expose
    private String time_start;
    @SerializedName("time_end")
    @Expose
    private String time_end;
    @SerializedName("base_url")
    @Expose
    private String base_url;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("ast")
    @Expose
    private ArrayList<Asts> astsList = new ArrayList<>();

    public String getSchedule_title() {
        return schedule_title;
    }

    public void setSchedule_title(String schedule_title) {
        this.schedule_title = schedule_title;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public ArrayList<Asts> getAstsList() {
        return astsList;
    }

    public void setAstsList(ArrayList<Asts> astsList) {
        this.astsList = astsList;
    }
}
