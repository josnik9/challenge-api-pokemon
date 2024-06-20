package com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon;

import com.challengetest.apipokemon.api.v1.client.requestresponses.global.NamedApiResource;

public class PokemonType {

	private Integer slot;
	private NamedApiResource type;

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public NamedApiResource getType() {
		return type;
	}

	public void setType(NamedApiResource type) {
		this.type = type;
	}
}
