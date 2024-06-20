package com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon;

import com.challengetest.apipokemon.api.v1.client.requestresponses.global.NamedApiResource;

public class PokemonHeldItemVersion {

	private NamedApiResource version;
	private Integer rarity;
	
	public NamedApiResource getVersion() {
		return version;
	}

	public void setVersion(NamedApiResource version) {
		this.version = version;
	}

	public Integer getRarity() {
		return rarity;
	}

	public void setRarity(Integer rarity) {
		this.rarity = rarity;
	}
}
