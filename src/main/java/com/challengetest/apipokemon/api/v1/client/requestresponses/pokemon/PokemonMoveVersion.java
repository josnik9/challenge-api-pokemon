package com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon;

import com.challengetest.apipokemon.api.v1.client.requestresponses.global.NamedApiResource;

public class PokemonMoveVersion {

	private NamedApiResource moveLearnMethod;
	private NamedApiResource versionGroup;
	private Integer levelLearnedAt;

	public NamedApiResource getMoveLearnMethod() {
		return moveLearnMethod;
	}

	public void setMoveLearnMethod(NamedApiResource moveLearnMethod) {
		this.moveLearnMethod = moveLearnMethod;
	}

	public NamedApiResource getVersionGroup() {
		return versionGroup;
	}

	public void setVersionGroup(NamedApiResource versionGroup) {
		this.versionGroup = versionGroup;
	}

	public Integer getLevelLearnedAt() {
		return levelLearnedAt;
	}

	public void setLevelLearnedAt(Integer levelLearnedAt) {
		this.levelLearnedAt = levelLearnedAt;
	}
}
