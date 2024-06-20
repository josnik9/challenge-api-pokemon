package com.challengetest.apipokemon.api.v1.usecases.interactors;

import com.challengetest.apipokemon.api.v1.domains.factories.RequestFactory;
import com.challengetest.apipokemon.api.v1.persistence.gateways.RequestGateway;
import com.challengetest.apipokemon.api.v1.usecases.bundaries.RequestBoundary;

import java.util.Date;

public class RequestInteractor implements RequestBoundary {

    private final RequestGateway requestGateway;
    private final RequestFactory requestFactory;

    public RequestInteractor(RequestGateway requestGateway, RequestFactory requestFactory) {
        this.requestGateway = requestGateway;
        this.requestFactory = requestFactory;
    }

    @Override
    public void save(String ip, Date date, String actionName) {
        requestGateway.save(requestFactory.create(ip, date, actionName));
    }

}
