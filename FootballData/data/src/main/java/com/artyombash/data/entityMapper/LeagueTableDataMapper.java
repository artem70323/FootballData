package com.artyombash.data.entityMapper;

import com.artyombash.data.entity.leagueTable.AwayData;
import com.artyombash.data.entity.leagueTable.HomeData;
import com.artyombash.data.entity.leagueTable.LeagueTableData;
import com.artyombash.data.entity.leagueTable.StandingData;
import com.artyombash.domain.entity.leagueTable.Away;
import com.artyombash.domain.entity.leagueTable.Home;
import com.artyombash.domain.entity.leagueTable.LeagueTable;
import com.artyombash.domain.entity.leagueTable.Standing;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link LeagueTableData} (in the data layer) to {@link LeagueTable}
 * in the domain layer.
 */
@Singleton
public class LeagueTableDataMapper {

    @Inject
    public LeagueTableDataMapper() {}

    public LeagueTable transform(LeagueTableData leagueTableData) {
        LeagueTable leagueTable = null;
        if (leagueTableData != null) {
            leagueTable = new LeagueTable();
            leagueTable.setLeagueCaption(leagueTableData.getLeagueCaption());
            leagueTable.setMatchday(leagueTableData.getMatchday());
            leagueTable.setStanding(transformStandings(leagueTableData.getStanding()));
        }
        return leagueTable;
    }

    private List<Standing> transformStandings(List<StandingData> standingDataList) {
        List<Standing> standings = null;
        if (standingDataList != null) {
            standings = new ArrayList<>();
            Standing standing;
            for (StandingData standingData : standingDataList) {
                standing = new Standing();
                standing.setPosition(standingData.getPosition());
                standing.setTeamName(standingData.getTeamName());
                standing.setCrestURI(standingData.getCrestURI());
                standing.setPlayedGames(standingData.getPlayedGames());
                standing.setPoints(standingData.getPoints());
                standing.setGoals(standingData.getGoals());
                standing.setGoalsAgainst(standingData.getGoalsAgainst());
                standing.setGoalDifference(standingData.getGoalDifference());
                standing.setWins(standingData.getWins());
                standing.setDraws(standingData.getDraws());
                standing.setLosses(standingData.getLosses());
                standing.setHome(transformHomeData(standingData.getHome()));
                standing.setAway(transformAwayData(standingData.getAway()));
                standings.add(standing);
            }
        }
        return standings;
    }

    private Home transformHomeData(HomeData homeData) {
        Home home = null;
        if (homeData != null) {
            home = new Home();
            home.setGoals(homeData.getGoals());
            home.setGoalsAgainst(homeData.getGoalsAgainst());
            home.setWins(homeData.getWins());
            home.setDraws(homeData.getDraws());
            home.setLosses(homeData.getLosses());
        }
        return home;
    }

    private Away transformAwayData(AwayData awayData) {
        Away away = null;
        if (awayData != null) {
            away = new Away();
            away.setGoals(awayData.getGoals());
            away.setGoalsAgainst(awayData.getGoalsAgainst());
            away.setWins(awayData.getWins());
            away.setDraws(awayData.getDraws());
            away.setLosses(awayData.getLosses());
        }
        return away;
    }

}
