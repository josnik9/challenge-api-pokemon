package com.challengetest.apipokemon.api.v1.domains.factories;

import com.challengetest.apipokemon.api.v1.domains.Request;

import java.util.Date;

public interface RequestFactory {

    Request create(String ip, Date date, String actionName);
}
