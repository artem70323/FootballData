package com.artyombash.data.cache;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;
import com.artyombash.data.entity.teams.TeamsData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Helper class to do operations on regular files/directories.
 */
@Singleton
public class FileManager {

    private Realm realm;
    private static final String URL = "http://api.football-data.org/v1/competitions/";

    @Inject
    FileManager() {}

    List<CompetitionData> getCompetitionsData() {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<CompetitionData> results = realm.where(CompetitionData.class).findAll();
        List<CompetitionData> list = realm.copyFromRealm(results);
        realm.commitTransaction();
        realm.close();
        return list;
    }

    TeamsData getTeamsData(int id) {
        String newId = URL + String.valueOf(id) + "/teams";
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        TeamsData realmObject = realm.where(TeamsData.class).equalTo("id", newId).findFirst();
        TeamsData data = realm.copyFromRealm(realmObject);
        realm.commitTransaction();
        realm.close();
        return data;
    }

    LeagueTableData getLeagueTableData(int id) {
        String newId = URL + String.valueOf(id);
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        LeagueTableData realmObject = realm.where(LeagueTableData.class).equalTo("id", newId).findFirst();
        LeagueTableData data = realm.copyFromRealm(realmObject);
        realm.commitTransaction();
        realm.close();
        return data;
    }

    FixturesData getFixturesData(int id) {
        String newId = URL + String.valueOf(id) + "/fixtures";
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        FixturesData realmObject = realm.where(FixturesData.class).equalTo("id", newId).findFirst();
        FixturesData data = realm.copyFromRealm(realmObject);
        realm.commitTransaction();
        realm.close();
        return data;
    }

    void putCompetitionsData(List<CompetitionData> list) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(list);
        realm.commitTransaction();
        realm.close();
    }

    void putTeamsData (TeamsData data) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(data);
        realm.commitTransaction();
        realm.close();
    }

    void putLeagueTableData (LeagueTableData data) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(data);
        realm.commitTransaction();
        realm.close();
    }

    void putFixturesData (FixturesData data) {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(data);
        realm.commitTransaction();
        realm.close();
    }

    /**
     * Write a value to a user preferences file.
     *
     * @param context {@link android.content.Context} to retrieve android user preferences.
     * @param preferenceFileName A file name reprensenting where data will be written to.
     * @param key A string for the key that will be used to retrieve the value in the future.
     * @param value A long representing the value to be inserted.
     */
    void writeToPreferences(Context context, String preferenceFileName, String key, long value) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName,
                Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    boolean exists(Context context, String name, String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedPreferences.contains(id);
    }


    long getFromPreferences(Context context, String name, String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(id, 0);
    }
}
