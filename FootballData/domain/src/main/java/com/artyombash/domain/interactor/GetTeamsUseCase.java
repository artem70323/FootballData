package com.artyombash.domain.interactor;

import com.artyombash.domain.entity.teams.Teams;
import com.artyombash.domain.executor.PostExecutionThread;
import com.artyombash.domain.executor.ThreadExecutor;
import com.artyombash.domain.repository.FootballRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link Teams} for a certain competition..
 */
public class GetTeamsUseCase extends UseCase<GetTeamsUseCase.Params, Teams> {

    private final FootballRepository repository;

    @Inject
    public GetTeamsUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                           FootballRepository repository) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    protected Observable<Teams> buildUseCase(Params params) {
        return repository.teams(params.competitionId);
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
