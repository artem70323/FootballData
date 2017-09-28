package com.artyombash.presentation.viewModel.leagueTable;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.artyombash.domain.entity.leagueTable.Standing;
import com.artyombash.presentation.base.BaseItemViewModel;

public class LeagueTableItemViewModel extends BaseItemViewModel<Standing> {

    public final ObservableInt position = new ObservableInt();
    public final ObservableField<String> teamName = new ObservableField<>("");
    public final ObservableInt playedGames = new ObservableInt();
    public final ObservableInt points = new ObservableInt();
    public final ObservableInt goals = new ObservableInt();
    public final ObservableInt goalsAgainst = new ObservableInt();
    public final ObservableInt goalDifference = new ObservableInt();
    public final ObservableInt wins = new ObservableInt();
    public final ObservableInt draws = new ObservableInt();
    public final ObservableInt losses = new ObservableInt();
    public final ObservableInt homeGoals = new ObservableInt();
    public final ObservableInt homeGoalsAgainst = new ObservableInt();
    public final ObservableInt homeWins = new ObservableInt();
    public final ObservableInt homeDraws = new ObservableInt();
    public final ObservableInt homeLosses = new ObservableInt();
    public final ObservableInt awayGoals = new ObservableInt();
    public final ObservableInt awayGoalsAgainst = new ObservableInt();
    public final ObservableInt awayWins = new ObservableInt();
    public final ObservableInt awayDraws = new ObservableInt();
    public final ObservableInt awayLosses = new ObservableInt();

    @Override
    public void setItem(Standing item) {
        position.set(item.getPosition());
        teamName.set(item.getTeamName());
        playedGames.set(item.getPlayedGames());
        points.set(item.getPoints());
        goals.set(item.getGoals());
        goalsAgainst.set(item.getGoalsAgainst());
        goalDifference.set(item.getGoalDifference());
        wins.set(item.getWins());
        draws.set(item.getDraws());
        losses.set(item.getLosses());
        homeGoals.set(item.getHome().getGoals());
        homeGoalsAgainst.set(item.getHome().getGoalsAgainst());
        homeWins.set(item.getHome().getWins());
        homeDraws.set(item.getHome().getDraws());
        homeLosses.set(item.getHome().getLosses());
        awayGoals.set(item.getAway().getGoals());
        awayGoalsAgainst.set(item.getAway().getGoalsAgainst());
        awayWins.set(item.getAway().getWins());
        awayDraws.set(item.getAway().getDraws());
        awayLosses.set(item.getAway().getLosses());
    }

}
