package com.artyombash.presentation.viewModel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.artyombash.domain.entity.Competition;
import com.artyombash.presentation.base.BaseItemViewModel;

public class CompetitionItemViewModel extends BaseItemViewModel<Competition> {

    public final ObservableInt id = new ObservableInt();
    public final ObservableField<String> caption = new ObservableField<>("");
    public final ObservableField<String> league = new ObservableField<>("");
    public final ObservableField<String> year = new ObservableField<>("");
    public final ObservableInt currentMatchday = new ObservableInt();
    public final ObservableInt numberOfMatchdays = new ObservableInt();
    public final ObservableInt numberOfTeams = new ObservableInt();
    public final ObservableInt numberOfGames = new ObservableInt();
    public final ObservableField<String> lastUpdated = new ObservableField<>("");


    @Override
    public void setItem(Competition item) {
        id.set(item.getId());
        caption.set(item.getCaption());
        league.set(item.getLeague());
        year.set(item.getYear());
        currentMatchday.set(item.getCurrentMatchday());
        numberOfMatchdays.set(item.getNumberOfMatchdays());
        numberOfTeams.set(item.getNumberOfTeams());
        numberOfGames.set(item.getNumberOfGames());
        lastUpdated.set(item.getLastUpdated());
    }

}
