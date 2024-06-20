package com.challengetest.apipokemon.utils.configs;

import com.challengetest.apipokemon.api.v1.usecases.bundaries.RequestBoundary;
import com.challengetest.apipokemon.interceptors.SOAPServiceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;

import java.util.List;

@EnableWs
@Configuration
public class SoapServerConfig extends WsConfigurerAdapter {

    private final RequestBoundary requestBoundary;

    public SoapServerConfig(RequestBoundary requestBoundary) {
        this.requestBoundary = requestBoundary;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(new SOAPServiceInterceptor(requestBoundary));
    }
}
