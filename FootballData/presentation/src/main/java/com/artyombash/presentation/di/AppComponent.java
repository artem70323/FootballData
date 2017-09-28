package com.artyombash.presentation.di;


import com.artyombash.presentation.activity.FixturesActivity;
import com.artyombash.presentation.activity.LeagueTableActivity;
import com.artyombash.presentation.activity.MainActivity;
import com.artyombash.presentation.activity.TeamsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RestModule.class})
@Singleton
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(TeamsActivity teamsActivity);
    void inject(LeagueTableActivity teamsActivity);
    void inject(FixturesActivity teamsActivity);

}
