package com.challengetest.apipokemon.utils.configs.beans;

import com.challengetest.apipokemon.api.v1.domains.factories.RequestFactory;
import com.challengetest.apipokemon.api.v1.domains.factories.RequestFactoryImpl;
import com.challengetest.apipokemon.api.v1.persistence.adapters.RequestJpa;
import com.challengetest.apipokemon.api.v1.persistence.gateways.RequestGateway;
import com.challengetest.apipokemon.api.v1.persistence.repositories.RequestRepo;
import com.challengetest.apipokemon.api.v1.usecases.bundaries.RequestBoundary;
import com.challengetest.apipokemon.api.v1.usecases.interactors.RequestInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestConfiguration {

    @Bean
    public RequestBoundary requestBoundary(RequestGateway requestGateway, RequestFactory requestFactory) {
        return new RequestInteractor(requestGateway, requestFactory);
    }

    @Bean
    public RequestGateway requestGateway(RequestRepo requestRepo) {
        return new RequestJpa(requestRepo);
    }

    @Bean
    public RequestFactory requestFactory() {
        return new RequestFactoryImpl();
    }
}
