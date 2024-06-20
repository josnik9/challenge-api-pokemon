package com.challengetest.apipokemon.api.v1.client.configs;

import com.challengetest.apipokemon.api.v1.client.requestresponses.Resource;
import reactor.core.publisher.Mono;


public interface PokemonApiEntityFactory {

	<T extends Resource> Mono<T> getResource(Class<T> resourceClass, String name);
	
}
