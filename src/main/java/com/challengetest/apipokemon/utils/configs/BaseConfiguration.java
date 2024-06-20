package com.challengetest.apipokemon.utils.configs;

import com.challengetest.apipokemon.api.v1.client.configs.PokemonApiEndpointRegistry;
import com.challengetest.apipokemon.api.v1.client.configs.PokemonApiEntityFactory;
import com.challengetest.apipokemon.api.v1.client.configs.WebClientEntityFactory;
import com.challengetest.apipokemon.utils.MapperSingleton;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration
@Import(EndpointActionsConfiguration.class)
public class BaseConfiguration {
	public static final String CONFIGURATION_PROPERTIES_PREFIX = "skaro.pokeapi";
	public static final String POKEAPI_WEBCLIENT_BEAN = "pokeapiWebClientBean";
	public static final String POKEAPI_JSON_DECODER_BEAN = "pokeapiDecoderBean";
	public static final String POKEAPI_JSON_ENCODER_BEAN = "pokeapiEncoderBean";
	
	@Bean
//	@Valid
	@ConfigurationProperties(CONFIGURATION_PROPERTIES_PREFIX)
	public ApiConfigurationProperties pokeApiConfigurationProperties() {
		return new ApiConfigurationProperties();
	}
	
	@Bean(POKEAPI_JSON_DECODER_BEAN)
	public Jackson2JsonDecoder jsonDecoder() {
		ObjectMapper mapper = MapperSingleton.instance();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return new Jackson2JsonDecoder(mapper, MediaType.APPLICATION_JSON);
	}
	
	@Bean(POKEAPI_JSON_ENCODER_BEAN)
	public Jackson2JsonEncoder jsonEncoder() {
		ObjectMapper mapper = MapperSingleton.instance();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
		
		return new Jackson2JsonEncoder(mapper, MediaType.APPLICATION_JSON);
	}
	
	@Bean(POKEAPI_WEBCLIENT_BEAN)
	public WebClient webClient(HttpClient httpClient,
			@Qualifier(POKEAPI_JSON_ENCODER_BEAN) Jackson2JsonEncoder encoder,
			@Qualifier(POKEAPI_JSON_DECODER_BEAN) Jackson2JsonDecoder decoder,
			ApiConfigurationProperties configurationProperties) {
		
		ExchangeStrategies strategies = ExchangeStrategies.builder()
	            .codecs(clientDefaultCodecsConfigurer -> {
	            	clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonEncoder(encoder);
	                clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonDecoder(decoder);
	            }).build();
		
		ExchangeFilterFunction logRequest = ExchangeFilterFunction.ofRequestProcessor(request -> {
			Logger log = LoggerFactory.getLogger(PokemonApiEntityFactory.class);
			log.info("{} {}",request.method(), request.url());
			return Mono.just(request);
		});
		
		return WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.baseUrl(configurationProperties.getBaseUri().toString())
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.exchangeStrategies(strategies)
				.filter(logRequest)
				.codecs(configurer -> configurer.defaultCodecs()
						.maxInMemorySize(configurationProperties.getMaxBytesToBuffer()))
				.build();
	}
	
	@Bean
	public PokemonApiEntityFactory pokeApiEntityFactory(WebClient webClient, PokemonApiEndpointRegistry registry) {
		return new WebClientEntityFactory(webClient, registry);
	}
	
}
