package com.artyombash.data.entity.links;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Links to {@link LinkToSelfData}, {@link LinkToFixturesData} and {@link LinkToPlayersData}.
 */

public class LinksToTeamData extends RealmObject {

    @SerializedName("self")
    private LinkToSelfData self;
    @SerializedName("fixtures")
    private LinkToFixturesData fixtures;
    @SerializedName("players")
    private LinkToPlayersData players;

    public LinkToSelfData getSelf() {
        return self;
    }

    public void setSelf(LinkToSelfData self) {
        this.self = self;
    }

    public LinkToFixturesData getFixtures() {
        return fixtures;
    }

    public void setFixtures(LinkToFixturesData fixtures) {
        this.fixtures = fixtures;
    }

    public LinkToPlayersData getPlayers() {
        return players;
    }

    public void setPlayers(LinkToPlayersData players) {
        this.players = players;
    }

}
