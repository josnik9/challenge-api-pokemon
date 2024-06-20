package com.challengetest.apipokemon.utils.configs;

import com.challengetest.apipokemon.api.v1.client.configs.MapEndpointRegistry;
import com.challengetest.apipokemon.api.v1.client.configs.PokemonApiEndpointRegistry;
import com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon.Pokemon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EndpointActionsConfiguration {

	/**
	 * To future, when It'll be necessary map another actions of API Pokemon
	 * @return Interface with mapping actions
	 */
	@Bean
	public PokemonApiEndpointRegistry endpointRegistry() {
		Map<Class<?>, String> actions = new HashMap<>();
		actions.put(Pokemon.class, "pokemon");
		
		return new MapEndpointRegistry(actions);
	}
	
}
