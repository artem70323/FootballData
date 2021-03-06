package com.artyombash.data.entity.fixtures;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class HalfTimeData extends RealmObject {

    @SerializedName("goalsHomeTeam")
    private Integer goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    private Integer goalsAwayTeam;

    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

}
