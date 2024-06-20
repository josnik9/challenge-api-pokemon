package com.challengetest.apipokemon.utils.configs.beans;

import com.challengetest.apipokemon.api.v1.client.configs.PokemonApiClient;
import com.challengetest.apipokemon.api.v1.usecases.bundaries.PokemonBoundary;
import com.challengetest.apipokemon.api.v1.usecases.interactors.PokemonInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PokemonConfiguration {

    @Bean
    public PokemonBoundary pokemonBoundary(PokemonApiClient pokeApiClient) {
        return new PokemonInteractor(pokeApiClient);
    }
}
