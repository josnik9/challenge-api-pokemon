package com.challengetest.apipokemon.api.v1.client.requestresponses.global;

public class VersionGameIndex {

	private Integer gameIndex;
	private NamedApiResource version;

	public Integer getGameIndex() {
		return gameIndex;
	}

	public void setGameIndex(Integer gameIndex) {
		this.gameIndex = gameIndex;
	}

	public NamedApiResource getVersion() {
		return version;
	}

	public void setVersion(NamedApiResource version) {
		this.version = version;
	}
}
