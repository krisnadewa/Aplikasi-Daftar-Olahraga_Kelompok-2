package com.example.projectsatu.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListSports {
    @SerializedName("sports")
    private List<Sport> sports;

    public ListSports() {
    }

    public List<Sport> getSports() {
        return sports;
    }
}
