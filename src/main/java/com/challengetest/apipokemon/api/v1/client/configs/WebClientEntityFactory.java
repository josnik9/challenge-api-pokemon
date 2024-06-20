package com.challengetest.apipokemon.api.v1.client.configs;

import com.challengetest.apipokemon.api.v1.client.requestresponses.Resource;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientEntityFactory implements PokemonApiEntityFactory {

	private final WebClient webClient;
	private final PokemonApiEndpointRegistry endpointRegistry;

	public WebClientEntityFactory(WebClient webClient, PokemonApiEndpointRegistry endpointRegistry) {
		this.webClient = webClient;
		this.endpointRegistry = endpointRegistry;
	}

	@Override
	public <T extends Resource> Mono<T> getResource(Class<T> resourceClass, String name) {
		String endpoint = endpointRegistry.getEndpoint(resourceClass);
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path(endpoint)
						.path("/{id}")
						.build(name))
				.retrieve()
				.bodyToMono(resourceClass)
				.onErrorResume(e -> Mono.empty());
	}

}
