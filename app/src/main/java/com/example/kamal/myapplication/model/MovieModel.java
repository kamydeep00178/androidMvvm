package com.example.kamal.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kamal on 8/2/18.
 */

public class MovieModel {


    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }

    @SerializedName("data")
    List<DataModel> data;

    public class DataModel {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @SerializedName("name")
        String name;
    }

}
