package com.artyombash.presentation.viewModel.fixtures;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.artyombash.domain.entity.fixtures.Fixtures;
import com.artyombash.domain.interactor.GetFixturesUseCase;
import com.artyombash.domain.interactor.GetFixturesUseCase.Params;
import com.artyombash.presentation.activity.FixturesActivity;
import com.artyombash.presentation.adapter.fixtures.FixturesAdapter;
import com.artyombash.presentation.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class FixturesViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public ObservableInt count = new ObservableInt();

    private GetFixturesUseCase getFixturesUseCase;
    public FixturesAdapter adapter = new FixturesAdapter();

    @Inject
    FixturesViewModel(GetFixturesUseCase getFixturesUseCase) {
        this.getFixturesUseCase = getFixturesUseCase;
    }

    @Override
    public void init() {}

    @Override
    public void resume() {

        getFixturesUseCase.execute
                (Params.forCompetition(FixturesActivity.competitionId),
                        new DisposableObserver<Fixtures>() {

                    @Override
                    public void onNext(@NonNull Fixtures fixtures) {
                        count.set(fixtures.getCount());
                        adapter.setItems(fixtures.getFixtures());
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
        getFixturesUseCase.dispose();
    }

}
