package com.artyombash.data.entity.links;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Link to players.
 */
public class LinkToPlayersData extends RealmObject {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
