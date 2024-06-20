package com.challengetest.apipokemon.api.v1.client.requestresponses.pokemon;

import com.challengetest.apipokemon.api.v1.client.requestresponses.Resource;
import com.challengetest.apipokemon.api.v1.client.requestresponses.global.NamedApiResource;
import com.challengetest.apipokemon.api.v1.client.requestresponses.global.VersionGameIndex;

import java.util.List;

public class Pokemon implements Resource {

	private Integer id;
	private String name;
	private Integer baseExperience;
	private Integer height;
	private Boolean isDefault;
	private Integer order;
	private Integer weight;
	private List<PokemonAbility> abilities;
	private List<NamedApiResource> forms;
	private List<VersionGameIndex> gameIndices;
	private List<PokemonHeldItem> heldItems;
	private String locationAreaEncounters;
	private List<PokemonMove> moves;
	private PokemonSprites sprites;
	private NamedApiResource species;
	private List<PokemonStat> stats;
	private List<PokemonType> types;
	private List<PokemonTypePast> pastTypes;

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(Integer baseExperience) {
		this.baseExperience = baseExperience;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Boolean getDefault() {
		return isDefault;
	}

	public void setDefault(Boolean aDefault) {
		isDefault = aDefault;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<PokemonAbility> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<PokemonAbility> abilities) {
		this.abilities = abilities;
	}

	public List<NamedApiResource> getForms() {
		return forms;
	}

	public void setForms(List<NamedApiResource> forms) {
		this.forms = forms;
	}

	public List<VersionGameIndex> getGameIndices() {
		return gameIndices;
	}

	public void setGameIndices(List<VersionGameIndex> gameIndices) {
		this.gameIndices = gameIndices;
	}

	public List<PokemonHeldItem> getHeldItems() {
		return heldItems;
	}

	public void setHeldItems(List<PokemonHeldItem> heldItems) {
		this.heldItems = heldItems;
	}

	public String getLocationAreaEncounters() {
		return locationAreaEncounters;
	}

	public void setLocationAreaEncounters(String locationAreaEncounters) {
		this.locationAreaEncounters = locationAreaEncounters;
	}

	public List<PokemonMove> getMoves() {
		return moves;
	}

	public void setMoves(List<PokemonMove> moves) {
		this.moves = moves;
	}

	public PokemonSprites getSprites() {
		return sprites;
	}

	public void setSprites(PokemonSprites sprites) {
		this.sprites = sprites;
	}

	public NamedApiResource getSpecies() {
		return species;
	}

	public void setSpecies(NamedApiResource species) {
		this.species = species;
	}

	public List<PokemonStat> getStats() {
		return stats;
	}

	public void setStats(List<PokemonStat> stats) {
		this.stats = stats;
	}

	public List<PokemonType> getTypes() {
		return types;
	}

	public void setTypes(List<PokemonType> types) {
		this.types = types;
	}

	public List<PokemonTypePast> getPastTypes() {
		return pastTypes;
	}

	public void setPastTypes(List<PokemonTypePast> pastTypes) {
		this.pastTypes = pastTypes;
	}
}
