package com.challengetest.apipokemon.api.v1.endpoints;

import com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon.Pokemon;
import com.challengetest.apipokemon.api.v1.usecases.bundaries.PokemonBoundary;
import com.challengetest.apipokemon.utils.MapperSingleton;
import com.fasterxml.jackson.core.type.TypeReference;
import soappokemonschemas.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://apipokemon.io/challenges/technical-challenge";

    private final PokemonBoundary pokemonBoundary;

    public PokemonEndpoint(PokemonBoundary pokemonBoundary) {
        this.pokemonBoundary = pokemonBoundary;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public GetPokemonResponse getAbilities(@RequestPayload GetAbilitiesRequest request) {
        return pokemonBoundary.execute(request.getPokemonName(), Pokemon::getAbilities)
                .map(pokemonAbilities -> {
                    soappokemonschemas.Pokemon pokemon = new soappokemonschemas.Pokemon();
                    pokemon.setAbilities(MapperSingleton.instance().convertValue(pokemonAbilities, new TypeReference<>() {}));
                    return new GetPokemonResponse(pokemon);
                }).orElseGet(GetPokemonResponse::new);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public GetPokemonResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {
        return pokemonBoundary.execute(request.getPokemonName(), Pokemon::getBaseExperience)
                .map(baseExperience -> {
                    soappokemonschemas.Pokemon pokemon = new soappokemonschemas.Pokemon();
                    pokemon.setBaseExperience(BigInteger.valueOf(baseExperience));
                    return new GetPokemonResponse(pokemon);
                }).orElseGet(GetPokemonResponse::new);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public GetPokemonResponse getHeldItems(@RequestPayload GetHeldItemsRequest request) {
        return pokemonBoundary.execute(request.getPokemonName(), Pokemon::getHeldItems)
                .map(heldItems -> {
                    soappokemonschemas.Pokemon pokemon = new soappokemonschemas.Pokemon();
                    pokemon.setHeldItems(MapperSingleton.instance().convertValue(heldItems, new TypeReference<>() {}));
                    return new GetPokemonResponse(pokemon);
                }).orElseGet(GetPokemonResponse::new);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public GetPokemonResponse getHeldItems(@RequestPayload GetIdRequest request) {
        return pokemonBoundary.execute(request.getPokemonName(), Pokemon::getId)
                .map(id -> {
                    soappokemonschemas.Pokemon pokemon = new soappokemonschemas.Pokemon();
                    pokemon.setId(BigInteger.valueOf(id));
                    return new GetPokemonResponse(pokemon);
                }).orElseGet(GetPokemonResponse::new);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetPokemonResponse getHeldItems(@RequestPayload GetNameRequest request) {
        return pokemonBoundary.execute(request.getPokemonName(), Pokemon::getName)
                .map(name -> {
                    soappokemonschemas.Pokemon pokemon = new soappokemonschemas.Pokemon();
                    pokemon.setName(name);
                    return new GetPokemonResponse(pokemon);
                }).orElseGet(GetPokemonResponse::new);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public GetPokemonResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
        return pokemonBoundary.execute(request.getPokemonName(), Pokemon::getLocationAreaEncounters)
                .map(locationAreaEncounters -> {
                    soappokemonschemas.Pokemon pokemon = new soappokemonschemas.Pokemon();
                    pokemon.setLocationAreaEncounters(locationAreaEncounters);
                    return new GetPokemonResponse(pokemon);
                }).orElseGet(GetPokemonResponse::new);
    }

}
