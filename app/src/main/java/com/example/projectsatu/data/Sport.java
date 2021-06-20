package com.example.projectsatu.data;

import com.google.gson.annotations.SerializedName;

public class Sport {
    @SerializedName("strSport")
    private String strSport;
    @SerializedName("strSportDescription")
    private String strSportDescription;
    @SerializedName("strSportThumb")
    private String strSportThumb;

    public Sport() {
    }

    public Sport(String strSport, String strSportDescription, String strSportThumb) {
        this.strSport = strSport;
        this.strSportDescription = strSportDescription;
        this.strSportThumb = strSportThumb;
    }

    public String getStrSport() {
        return strSport;
    }

    public String getStrSportDescription() { return strSportDescription; }

    public String getStrSportThumb() {
        return strSportThumb;
    }
}
