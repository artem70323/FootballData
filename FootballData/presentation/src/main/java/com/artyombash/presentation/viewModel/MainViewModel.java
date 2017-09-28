package com.artyombash.presentation.viewModel;

import android.databinding.ObservableField;
import android.util.Log;

import com.artyombash.domain.entity.Competition;
import com.artyombash.domain.interactor.GetCompetitionsUseCase;
import com.artyombash.presentation.adapter.CompetitionAdapter;
import com.artyombash.presentation.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class MainViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private GetCompetitionsUseCase getCompetitionsUseCase;
    public CompetitionAdapter adapter = new CompetitionAdapter();

    @Inject
    public MainViewModel(GetCompetitionsUseCase getCompetitionsUseCase) {
        this.getCompetitionsUseCase = getCompetitionsUseCase;
    }

    @Override
    public void init() {}

    @Override
    public void resume() {

        getCompetitionsUseCase.execute
                (null, new DisposableObserver<List<Competition>>() {

                    @Override
                    public void onNext(@NonNull List<Competition> competitions) {
                        adapter.setItems(competitions);
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
        getCompetitionsUseCase.dispose();
    }

    private void execute() {

    }

}
