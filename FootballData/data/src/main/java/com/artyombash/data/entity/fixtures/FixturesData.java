package com.artyombash.data.entity.fixtures;

import com.artyombash.data.entity.links.LinksMainData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * List all fixtures for a certain competition.
 */
public class FixturesData extends RealmObject {

    @PrimaryKey
    @Required
    private String id;
    @SerializedName("_links")
    private LinksMainData links;
    @SerializedName("count")
    private Integer count;
    @SerializedName("fixtures")
    private RealmList<FixtureData> fixtures = null;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<FixtureData> getFixtures() {
        return fixtures;
    }

    public void setFixtures(RealmList<FixtureData> fixtures) {
        this.fixtures = fixtures;
    }

}
