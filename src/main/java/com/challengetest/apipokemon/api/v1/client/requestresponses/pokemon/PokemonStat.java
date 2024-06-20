package com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon;

import com.challengetest.apipokemon.api.v1.client.requestresponses.global.NamedApiResource;

public class PokemonStat {

	private NamedApiResource stat;
	private Integer effort;
	private Integer baseStat;

	public NamedApiResource getStat() {
		return stat;
	}

	public void setStat(NamedApiResource stat) {
		this.stat = stat;
	}

	public Integer getEffort() {
		return effort;
	}

	public void setEffort(Integer effort) {
		this.effort = effort;
	}

	public Integer getBaseStat() {
		return baseStat;
	}

	public void setBaseStat(Integer baseStat) {
		this.baseStat = baseStat;
	}
}
