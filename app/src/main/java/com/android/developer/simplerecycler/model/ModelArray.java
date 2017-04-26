package com.android.developer.simplerecycler.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HP on 15-04-2017.
 */

public class ModelArray {

    @SerializedName("data")
    @Expose
    private List<Model> data = null;

//    private String schedule_title, time_start, time_end;

    public List<Model> getData() {
        return data;
    }

    public void setData(List<Model> data) {
        this.data = data;
    }

}
