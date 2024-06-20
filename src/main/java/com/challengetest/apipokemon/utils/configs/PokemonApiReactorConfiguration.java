package com.challengetest.apipokemon.utils.configs;

import com.challengetest.apipokemon.api.v1.client.configs.PokemonApiClient;
import com.challengetest.apipokemon.api.v1.client.configs.PokemonApiEntityFactory;
import com.challengetest.apipokemon.api.v1.client.configs.ReactivePokemonApiClient;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;

@Configuration
@Import(BaseConfiguration.class)
public class PokemonApiReactorConfiguration {

	@Bean
	public PokemonApiClient pokeApiClient(PokemonApiEntityFactory entityFactory) {
		return new ReactivePokemonApiClient(entityFactory);
	}

	@Bean
	public ConnectionProvider connectionProvider() {
		return ConnectionProvider.builder("Refresh & no connection limit")
				.maxIdleTime(Duration.ofSeconds(10))
				.maxConnections(500)
				.pendingAcquireMaxCount(-1)
				.build();
	}

	@Bean
	public HttpClient httpClient(ConnectionProvider connectionProvider) {
		return HttpClient.create(connectionProvider)
				.compress(true)
				.resolver(DefaultAddressResolverGroup.INSTANCE);
	}
	
}
