package com.challengetest.apipokemon.api.v1.usecases.interactors;

import com.challengetest.apipokemon.api.v1.client.configs.PokemonApiClient;
import com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon.Pokemon;
import com.challengetest.apipokemon.api.v1.usecases.bundaries.PokemonBoundary;
import com.challengetest.apipokemon.suppliers.ConsumerReturn;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class PokemonInteractor implements PokemonBoundary {

    private final PokemonApiClient pokeApiClient;

    public PokemonInteractor(PokemonApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    @Override
    public <T> Optional<T> execute(String name, ConsumerReturn<Pokemon, T> methodCaller) {
        if (!StringUtils.hasLength(name)) { return Optional.empty(); }

        Pokemon pokemon = pokeApiClient.getResource(Pokemon.class, name.toLowerCase()).block();

        if (pokemon == null) { return Optional.empty(); }
        return Optional.ofNullable(methodCaller.call(pokemon));
    }

}
