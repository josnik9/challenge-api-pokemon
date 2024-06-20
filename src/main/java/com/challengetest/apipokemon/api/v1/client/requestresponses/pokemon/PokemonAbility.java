package com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon;

import com.challengetest.apipokemon.api.v1.client.requestresponses.global.NamedApiResource;

public class PokemonAbility {

	private Boolean isHidden;
	private Integer slot;
	private NamedApiResource ability;

	public Boolean getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public Boolean getHidden() {
		return isHidden;
	}

	public void setHidden(Boolean hidden) {
		isHidden = hidden;
	}

	public NamedApiResource getAbility() {
		return ability;
	}

	public void setAbility(NamedApiResource ability) {
		this.ability = ability;
	}
}
