package com.artyombash.data.cache;

import android.content.Context;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;
import com.artyombash.data.entity.teams.TeamsData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link Cache} implementation.
 */
@Singleton
public class CacheImpl implements Cache {

    private static final String SETTINGS_FILE_NAME = "CacheTimeLastUpdate";
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;
    private static final String COMPETITIONSID = "http://api.football-data.org/v1/competitions/";

    private Context context;
    private FileManager fileManager;

    @Inject
    CacheImpl(Context context, FileManager fileManager) {
        this.context = context;
        this.fileManager = fileManager;
    }

    @Override
    public Observable<List<CompetitionData>> getCompetitionsData() {
        return Observable.just(fileManager.getCompetitionsData());
    }

    @Override
    public Observable<TeamsData> getTeamsData(int teamsDataId) {
        return Observable.just(fileManager.getTeamsData(teamsDataId));
    }

    @Override
    public Observable<LeagueTableData> getLeagueTableData(int leagueTableDataId) {
        return Observable.just(fileManager.getLeagueTableData(leagueTableDataId));
    }

    @Override
    public Observable<FixturesData> getFixturesData(int fixturesDataId) {
        return Observable.just(fileManager.getFixturesData(fixturesDataId));
    }

    @Override
    public void putCompetitionsData(List<CompetitionData> competitionDataList) {
        fileManager.putCompetitionsData(competitionDataList);
        setLastUpdateTimeMillis(COMPETITIONSID);
    }

    @Override
    public void putTeamsData(TeamsData teamsData) {
        teamsData.setId(teamsData.getLinks().getSelf().getHref());
        fileManager.putTeamsData(teamsData);
        setLastUpdateTimeMillis(teamsData.getId());
    }

    @Override
    public void putLeagueTableData(LeagueTableData leagueTableData) {
        leagueTableData.setId(leagueTableData.getLinks().getCompetition().getHref());
        fileManager.putLeagueTableData(leagueTableData);
        setLastUpdateTimeMillis(leagueTableData.getId());
    }

    @Override
    public void putFixturesData(FixturesData fixturesData) {
        fixturesData.setId(fixturesData.getLinks().getSelf().getHref());
        fileManager.putFixturesData(fixturesData);
        setLastUpdateTimeMillis(fixturesData.getId());
    }

    @Override
    public boolean isCached(String id) {
        return fileManager.exists(this.context, SETTINGS_FILE_NAME, id);
    }

    @Override
    public boolean isExpired(String id) {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = this.getLastCacheUpdateTimeMillis(id);
        return ((currentTime - lastUpdateTime) > EXPIRATION_TIME);
    }

    @Override
    public void evictAll() {
    }

    /**
     * Set in millis, the last time the cache was accessed.
     */
    private void setLastUpdateTimeMillis(String id) {
        final long currentMillis = System.currentTimeMillis();
        fileManager.writeToPreferences(this.context, SETTINGS_FILE_NAME, id, currentMillis);
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private long getLastCacheUpdateTimeMillis(String id) {
        return this.fileManager.getFromPreferences(this.context, SETTINGS_FILE_NAME, id);
    }


}
