package com.artyombash.data.cache;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;
import com.artyombash.data.entity.teams.TeamsData;

import java.util.List;

import io.reactivex.Observable;

/**
 * An interface representing a Cache.
 */
public interface Cache {

    /**
     * Gets an {@link Observable} which will emit a list of {@link CompetitionData}.
     */
    Observable<List<CompetitionData>> getCompetitionsData();

    /**
     * Gets an {@link Observable} which will emit a {@link TeamsData}.
     *
     * @param teamsDataId TeamsData id to retrieve data.
     */
    Observable<TeamsData> getTeamsData(final int teamsDataId);

    /**
     * Gets an {@link Observable} which will emit a {@link LeagueTableData}.
     *
     * @param leagueTableDataId LeagueTableData id to retrieve data.
     */
    Observable<LeagueTableData> getLeagueTableData(final int leagueTableDataId);

    /**
     * Gets an {@link Observable} which will emit a {@link FixturesData}.
     *
     * @param fixturesDataId FixturesData id to retrieve data.
     */
    Observable<FixturesData> getFixturesData(final int fixturesDataId);

    /**
     * Puts and element into the cache.
     *
     * @param competitionDataList Element to insert in the cache.
     */
    void putCompetitionsData (List<CompetitionData> competitionDataList);

    /**
     * Puts and element into the cache.
     *
     * @param teamsData Element to insert in the cache.
     */
    void putTeamsData (TeamsData teamsData);

    /**
     * Puts and element into the cache.
     *
     * @param leagueTableData Element to insert in the cache.
     */
    void putLeagueTableData (LeagueTableData leagueTableData);

    /**
     * Puts and element into the cache.
     *
     * @param fixturesData Element to insert in the cache.
     */
    void putFixturesData (FixturesData fixturesData);

    /**
     * Checks if an element exists in the cache.
     *
     * @param id Id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final String id);

    /**
     * Checks if the cache is expired.
     *
     * @param id Id used to know if the cache is expired.
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired(final String id);

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
