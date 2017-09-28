package com.artyombash.data.entity.fixtures;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Link to HomeTeam.
 */
public class HomeTeamData extends RealmObject {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
