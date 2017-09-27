package com.artyombash.presentation.viewModel.teams;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.artyombash.domain.entity.teams.Teams;
import com.artyombash.domain.interactor.GetTeamsUseCase;
import com.artyombash.domain.interactor.GetTeamsUseCase.Params;
import com.artyombash.presentation.activity.TeamsActivity;
import com.artyombash.presentation.adapter.teams.TeamsAdapter;
import com.artyombash.presentation.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class TeamsViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public ObservableInt count = new ObservableInt();

    private GetTeamsUseCase getTeamsUseCase;
    public TeamsAdapter adapter = new TeamsAdapter();

    @Inject
    TeamsViewModel(GetTeamsUseCase getTeamsUseCase) {
        this.getTeamsUseCase = getTeamsUseCase;
    }

    @Override
    public void init() {}

    @Override
    public void resume() {

        getTeamsUseCase.execute
                (Params.forCompetition(TeamsActivity.competitionId), new DisposableObserver<Teams>() {

                    @Override
                    public void onNext(@NonNull Teams teams) {
                        count.set(teams.getCount());
                        adapter.setItems(teams.getTeams());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("Error", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        state.set(STATE.DATA);
                    }
                });
    }

    @Override
    public void pause() {}

    @Override
    public void destroy() {
        getTeamsUseCase.dispose();
    }

}
