package com.artyombash.presentation.viewModel.leagueTable;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.artyombash.domain.entity.leagueTable.LeagueTable;
import com.artyombash.domain.interactor.GetLeagueTableUseCase;
import com.artyombash.domain.interactor.GetLeagueTableUseCase.Params;
import com.artyombash.presentation.activity.LeagueTableActivity;
import com.artyombash.presentation.adapter.leagueTable.LeagueTableAdapter;
import com.artyombash.presentation.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class LeagueTableViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public ObservableField<String> leagueCaption = new ObservableField<>();
    public ObservableInt matchday = new ObservableInt();

    private GetLeagueTableUseCase getLeagueTableUseCase;
    public LeagueTableAdapter adapter = new LeagueTableAdapter();

    @Inject
    LeagueTableViewModel(GetLeagueTableUseCase getLeagueTableUseCase) {
        this.getLeagueTableUseCase = getLeagueTableUseCase;
    }

    @Override
    public void init() {}

    @Override
    public void resume() {

        getLeagueTableUseCase.execute
                (Params.forCompetition(LeagueTableActivity.competitionId),
                        new DisposableObserver<LeagueTable>() {

                    @Override
                    public void onNext(@NonNull LeagueTable leagueTable) {
                        leagueCaption.set(leagueTable.getLeagueCaption());
                        matchday.set(leagueTable.getMatchday());
                        adapter.setItems(leagueTable.getStanding());
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
        getLeagueTableUseCase.dispose();
    }

}
