package com.artyombash.presentation.viewModel.fixtures;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.artyombash.domain.entity.fixtures.Fixture;
import com.artyombash.presentation.base.BaseItemViewModel;

public class FixturesItemViewModel extends BaseItemViewModel<Fixture> {

    public final ObservableField<String> date = new ObservableField<>("");
    public final ObservableField<String> status = new ObservableField<>("");
    public final ObservableInt matchday = new ObservableInt();
    public final ObservableField<String> homeTeamName = new ObservableField<>("");
    public final ObservableField<String> awayTeamName = new ObservableField<>("");
    public final ObservableInt goalsHomeTeam = new ObservableInt();
    public final ObservableInt goalsAwayTeam = new ObservableInt();
    public final ObservableInt goalsHomeTeamHalf = new ObservableInt();
    public final ObservableInt goalsAwayTeamHalf = new ObservableInt();
    public final ObservableField<String> nul = new ObservableField<>("");

    @Override
    public void setItem(Fixture item) {
        date.set(item.getDate());
        status.set(item.getStatus());
        matchday.set(item.getMatchday());
        homeTeamName.set(item.getHomeTeamName());
        awayTeamName.set(item.getAwayTeamName());
        goalsHomeTeam.set(item.getResult().getGoalsHomeTeam());
        goalsAwayTeam.set(item.getResult().getGoalsAwayTeam());
        if (item.getResult().getHalfTime() == null) {
            goalsHomeTeamHalf.set(-1);
            goalsAwayTeamHalf.set(-1);
            return;
        }
        goalsHomeTeamHalf.set(item.getResult().getHalfTime().getGoalsHomeTeam());
        goalsAwayTeamHalf.set(item.getResult().getHalfTime().getGoalsAwayTeam());
    }

}
