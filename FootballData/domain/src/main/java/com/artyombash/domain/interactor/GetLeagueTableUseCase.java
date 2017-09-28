package com.artyombash.domain.interactor;

import com.artyombash.domain.entity.leagueTable.LeagueTable;
import com.artyombash.domain.executor.PostExecutionThread;
import com.artyombash.domain.executor.ThreadExecutor;
import com.artyombash.domain.repository.FootballRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a {@link LeagueTable} for a certain competition..
 */
public class GetLeagueTableUseCase extends UseCase<GetLeagueTableUseCase.Params, LeagueTable> {

    private final FootballRepository repository;

    @Inject
    public GetLeagueTableUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                 FootballRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<LeagueTable> buildUseCase(Params params) {
        return repository.leagueTable(params.competitionId);
    }

    public static final class Params {

        private final int competitionId;

        private Params(int competitionId) {
            this.competitionId = competitionId;
        }

        public static Params forCompetition(int competitionId) {
            return new Params(competitionId);
        }
    }

}
