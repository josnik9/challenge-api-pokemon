package com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon;

import com.challengetest.apipokemon.api.v1.client.requestresponses.global.NamedApiResource;

import java.util.List;

public class PokemonMove {

	private NamedApiResource move;
	private List<PokemonMoveVersion> versionGroupDetails;

	public NamedApiResource getMove() {
		return move;
	}

	public void setMove(NamedApiResource move) {
		this.move = move;
	}

	public List<PokemonMoveVersion> getVersionGroupDetails() {
		return versionGroupDetails;
	}

	public void setVersionGroupDetails(List<PokemonMoveVersion> versionGroupDetails) {
		this.versionGroupDetails = versionGroupDetails;
	}
}
