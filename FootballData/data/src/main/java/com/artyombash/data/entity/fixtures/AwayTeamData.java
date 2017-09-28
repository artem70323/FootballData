package com.artyombash.data.entity.fixtures;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Link to AwayTeam.
 */
public class AwayTeamData extends RealmObject {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
