package com.artyombash.data.entity.leagueTable;


import com.artyombash.data.entity.links.LinksMainData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class LeagueTableData extends RealmObject{

    @PrimaryKey
    @Required
    private String id;
    @SerializedName("_links")
    private LinksMainData links;
    @SerializedName("leagueCaption")
    private String leagueCaption;
    @SerializedName("matchday")
    private Integer matchday;
    @SerializedName("standing")
    private RealmList<StandingData> standing = null;

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

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public List<StandingData> getStanding() {
        return standing;
    }

    public void setStanding(RealmList<StandingData> standing) {
        this.standing = standing;
    }
}
