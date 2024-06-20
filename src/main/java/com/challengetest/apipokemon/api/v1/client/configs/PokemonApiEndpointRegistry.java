package com.challengetest.apipokemon.api.v1.client.configs;

import com.challengetest.apipokemon.api.v1.client.requestresponses.Resource;

public interface PokemonApiEndpointRegistry {
	
	<T extends Resource> String getEndpoint(Class<T> resource);
	
}
