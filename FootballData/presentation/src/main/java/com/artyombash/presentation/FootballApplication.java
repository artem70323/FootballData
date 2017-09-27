package com.artyombash.presentation;


import android.app.Application;

import com.artyombash.data.BuildConfig;
import com.artyombash.presentation.di.AppComponent;
import com.artyombash.presentation.di.AppModule;
import com.artyombash.presentation.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;

/**
 * Android Main Application.
 */
public class FootballApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
        Realm.init(this);
    }

    private void initializeInjector() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return this.appComponent;
    }

    private void initializeLeakDetection() {
//        if (BuildConfig.DEBUG) {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
//        }
    }

}
