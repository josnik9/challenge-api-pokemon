package com.challengetest.apipokemon.api.v1.persistence.gateways;

import com.challengetest.apipokemon.api.v1.domains.Request;

public interface RequestGateway {

    void save(Request request);
}
