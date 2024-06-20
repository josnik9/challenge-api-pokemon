package com.challengetest.apipokemon.api.v1.client.configs;

import com.challengetest.apipokemon.api.v1.client.requestresponses.Resource;
import reactor.core.publisher.Mono;

public class ReactivePokemonApiClient implements PokemonApiClient {

	private final PokemonApiEntityFactory entityFactory;
	
	public ReactivePokemonApiClient(PokemonApiEntityFactory entityFactory) {
		this.entityFactory = entityFactory;
	}

	@Override
	public <T extends Resource> Mono<T> getResource(Class<T> cls, String name) {
		return entityFactory.getResource(cls, name);
	}

}
