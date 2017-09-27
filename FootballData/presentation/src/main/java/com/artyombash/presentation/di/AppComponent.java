package com.artyombash.presentation.di;


import com.artyombash.presentation.activity.MainActivity;
import com.artyombash.presentation.activity.TeamsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RestModule.class})
@Singleton
public interface AppComponent {

    public void inject(MainActivity mainActivity);
    public void inject(TeamsActivity teamsActivity);

}
