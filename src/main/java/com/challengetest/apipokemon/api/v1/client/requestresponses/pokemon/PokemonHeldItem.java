package com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon;

import com.challengetest.apipokemon.api.v1.client.requestresponses.global.NamedApiResource;

import java.util.List;

public class PokemonHeldItem {

	private NamedApiResource item;
	private List<PokemonHeldItemVersion> versionDetails;

	public NamedApiResource getItem() {
		return item;
	}

	public void setItem(NamedApiResource item) {
		this.item = item;
	}

	public List<PokemonHeldItemVersion> getVersionDetails() {
		return versionDetails;
	}

	public void setVersionDetails(List<PokemonHeldItemVersion> versionDetails) {
		this.versionDetails = versionDetails;
	}
}
