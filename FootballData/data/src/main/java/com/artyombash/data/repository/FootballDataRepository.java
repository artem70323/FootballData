package com.artyombash.data.repository;

import com.artyombash.data.entity.CompetitionData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;
import com.artyombash.data.entity.teams.TeamsData;
import com.artyombash.data.entityMapper.CompetitionDataMapper;
import com.artyombash.data.entityMapper.FixturesDataMapper;
import com.artyombash.data.entityMapper.LeagueTableDataMapper;
import com.artyombash.data.entityMapper.TeamsDataMapper;
import com.artyombash.data.repository.datasource.DataStore;
import com.artyombash.data.repository.datasource.DataStoreFactory;
import com.artyombash.domain.entity.Competition;
import com.artyombash.domain.entity.teams.Teams;
import com.artyombash.domain.entity.fixtures.Fixtures;
import com.artyombash.domain.entity.leagueTable.LeagueTable;
import com.artyombash.domain.repository.FootballRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * {@link FootballRepository} for retrieving football data.
 */
@Singleton
public class FootballDataRepository implements FootballRepository{

    private static final String COMPETITIONSID = "http://api.football-data.org/v1/competitions/";

    private final DataStoreFactory dataStoreFactory;
    private final CompetitionDataMapper competitionDataMapper;
    private final TeamsDataMapper teamsDataMapper;
    private final LeagueTableDataMapper leagueTableDataMapper;
    private final FixturesDataMapper fixturesDataMapper;

    /**
     * Constructs a {@link FootballRepository}.
     * @param dataStoreFactory A factory to construct different data source implementations.
     * @param competitionDataMapper {@link CompetitionDataMapper}.
     * @param teamsDataMapper {@link TeamsDataMapper}.
     * @param leagueTableDataMapper {@link LeagueTableDataMapper}.
     * @param fixturesDataMapper {@link FixturesDataMapper}.
     */
    @Inject
    public FootballDataRepository(DataStoreFactory dataStoreFactory,
                                  CompetitionDataMapper competitionDataMapper,
                                  TeamsDataMapper teamsDataMapper, LeagueTableDataMapper leagueTableDataMapper, FixturesDataMapper fixturesDataMapper) {
        this.dataStoreFactory = dataStoreFactory;
        this.competitionDataMapper = competitionDataMapper;
        this.teamsDataMapper = teamsDataMapper;
        this.leagueTableDataMapper = leagueTableDataMapper;
        this.fixturesDataMapper = fixturesDataMapper;
    }

    @Override
    public Observable<List<Competition>> competitions() {
        DataStore dataStore = this.dataStoreFactory.create(COMPETITIONSID);
        return dataStore.competitionDataList()
                .map(new Function<List<CompetitionData>, List<Competition>>() {
            @Override
            public List<Competition> apply(@NonNull List<CompetitionData> competitionDatas) throws Exception {
                return competitionDataMapper.transform(competitionDatas);
            }
        });
    }

    @Override
    public Observable<Teams> teams(int competitionId) {
        String newId = COMPETITIONSID + String.valueOf(competitionId) + "/teams";
        DataStore dataStore = this.dataStoreFactory.create(newId);
        return dataStore.teamsData(competitionId)
                .map(new Function<TeamsData, Teams>() {
                    @Override
                    public Teams apply(@NonNull TeamsData teamsData) throws Exception {
                        return teamsDataMapper.transform(teamsData);
                    }
                });
    }

    @Override
    public Observable<LeagueTable> leagueTable(int competitionId) {
        String newId = COMPETITIONSID + String.valueOf(competitionId);
        DataStore dataStore = this.dataStoreFactory.create(newId);
        return dataStore.leagueTableData(competitionId)
                .map(new Function<LeagueTableData, LeagueTable>() {
                    @Override
                    public LeagueTable apply(@NonNull LeagueTableData leagueTableData) throws Exception {
                        return leagueTableDataMapper.transform(leagueTableData);
                    }
                });
    }

    @Override
    public Observable<Fixtures> fixtures(int competitionId) {
        String newId = COMPETITIONSID + String.valueOf(competitionId) + "/fixtures";
        DataStore dataStore = this.dataStoreFactory.create(newId);
        return dataStore.fixturesData(competitionId)
                .map(new Function<FixturesData, Fixtures>() {
                    @Override
                    public Fixtures apply(@NonNull FixturesData fixturesData) throws Exception {
                        return fixturesDataMapper.transform(fixturesData);
                    }
                });
    }

}
