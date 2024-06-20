package com.challengetest.apipokemon.api.v1.client.configs;

import com.challengetest.apipokemon.api.v1.client.requestresponses.Resource;

import java.util.Collections;
import java.util.Map;

public class MapEndpointRegistry implements PokemonApiEndpointRegistry {

	private Map<Class<?>, String> actions;

	public MapEndpointRegistry(Map<Class<?>, String> endpoints) {
		this.actions = Collections.unmodifiableMap(endpoints);
	}

	@Override
	public <T extends Resource> String getEndpoint(Class<T> resource) {
		return actions.get(resource);
	}

}
