package com.challengetest.apipokemon.api.v1.usecases.bundaries;

import java.util.Date;

public interface RequestBoundary {

    void save(String ip, Date date, String actionName);
}
