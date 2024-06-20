package com.challengetest.apipokemon.api.v1.usecases.bundaries;

import com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon.Pokemon;
import com.challengetest.apipokemon.suppliers.ConsumerReturn;

import java.util.Optional;

public interface PokemonBoundary {

    <T> Optional<T> execute(String name, ConsumerReturn<Pokemon, T> methodCaller);
}
