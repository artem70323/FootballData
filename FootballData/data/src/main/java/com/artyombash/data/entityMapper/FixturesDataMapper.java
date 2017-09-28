package com.artyombash.data.entityMapper;

import com.artyombash.data.entity.fixtures.FixtureData;
import com.artyombash.data.entity.fixtures.FixturesData;
import com.artyombash.data.entity.fixtures.HalfTimeData;
import com.artyombash.data.entity.fixtures.ResultData;
import com.artyombash.domain.entity.fixtures.Fixture;
import com.artyombash.domain.entity.fixtures.Fixtures;
import com.artyombash.domain.entity.fixtures.HalfTime;
import com.artyombash.domain.entity.fixtures.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link FixturesData} (in the data layer) to {@link Fixtures}
 * in the domain layer.
 */
@Singleton
public class FixturesDataMapper {

    @Inject
    public FixturesDataMapper() {}

    public Fixtures transform(FixturesData fixturesData) {
        Fixtures fixtures = null;
        if (fixturesData != null) {
            fixtures = new Fixtures();
            fixtures.setCount(fixturesData.getCount());
            fixtures.setFixtures(transformFixture(fixturesData.getFixtures()));
        }
        return fixtures;
    }

    private List<Fixture> transformFixture(List<FixtureData> fixtureDataList) {
        List<Fixture> fixtureList = null;
        if (fixtureDataList != null) {
            fixtureList = new ArrayList<>();
            Fixture fixture;
            for(FixtureData fixtureData : fixtureDataList) {
                fixture = new Fixture();
                fixture.setDate(fixtureData.getDate());
                fixture.setStatus(fixtureData.getStatus());
                fixture.setMatchday(fixtureData.getMatchday());
                fixture.setHomeTeamName(fixtureData.getHomeTeamName());
                fixture.setAwayTeamName(fixtureData.getAwayTeamName());
                fixture.setResult(transformResultData(fixtureData.getResult()));
                fixtureList.add(fixture);
            }
        }
        return fixtureList;
    }

    private Result transformResultData(ResultData resultData) {
        Result result = null;
        if (resultData != null) {
            result = new Result();
            result.setGoalsHomeTeam(resultData.getGoalsHomeTeam());
            result.setGoalsAwayTeam(resultData.getGoalsAwayTeam());
            result.setHalfTime(transformHalfTimeData(resultData.getHalfTime()));
        }
        return result;
    }

    private HalfTime transformHalfTimeData(HalfTimeData halfTimeData) {
        HalfTime halfTime = null;
        if (halfTimeData != null) {
            halfTime = new HalfTime();
            halfTime.setGoalsHomeTeam(halfTimeData.getGoalsHomeTeam());
            halfTime.setGoalsAwayTeam(halfTimeData.getGoalsAwayTeam());
        }
        return halfTime;
    }

}
