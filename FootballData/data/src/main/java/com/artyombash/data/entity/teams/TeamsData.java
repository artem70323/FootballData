package com.artyombash.data.entity.teams;

import com.artyombash.data.entity.links.LinksMainData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * List all teams for a certain competition.
 */

public class TeamsData extends RealmObject {

    @PrimaryKey
    @Required
    private String id;
    @SerializedName("_links")
    private LinksMainData links;
    @SerializedName("count")
    private int count;
    @SerializedName("teams")
    private RealmList<TeamData> teams = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinksMainData getLinks() {
        return links;
    }

    public void setLinks(LinksMainData links) {
        this.links = links;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TeamData> getTeams() {
        return teams;
    }

    public void setTeams(RealmList<TeamData> teams) {
        this.teams = teams;
    }

}
