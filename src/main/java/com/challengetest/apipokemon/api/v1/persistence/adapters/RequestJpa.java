package com.challengetest.apipokemon.api.v1.persistence.adapters;

import com.challengetest.apipokemon.api.v1.domains.Request;
import com.challengetest.apipokemon.api.v1.persistence.entities.RequestEntity;
import com.challengetest.apipokemon.api.v1.persistence.gateways.RequestGateway;
import com.challengetest.apipokemon.api.v1.persistence.repositories.RequestRepo;
import com.challengetest.apipokemon.utils.MapperSingleton;

import java.util.Date;

public class RequestJpa implements RequestGateway {

    private final RequestRepo requestRepo;

    public RequestJpa(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }

    @Override
    public void save(Request request) {
        RequestEntity requestEntity = MapperSingleton.instance().convertValue(request, RequestEntity.class);
        requestEntity.updateCU(new Date().getTime());
        requestRepo.save(requestEntity);
    }
}
