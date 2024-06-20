package com.challengetest.apipokemon.api.v1.domains.factories;

import com.challengetest.apipokemon.api.v1.domains.Request;
import com.challengetest.apipokemon.api.v1.domains.RequestSOAP;

import java.util.Date;

public class RequestFactoryImpl implements RequestFactory {

    @Override
    public Request create(String ip, Date date, String actionName) {
        return new RequestSOAP(ip, date, actionName).removeSuffix();
    }
}
