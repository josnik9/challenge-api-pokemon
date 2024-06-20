package com.challengetest.apipokemon.api.v1.client.requestresponses.global;

import com.challengetest.apipokemon.api.v1.client.requestresponses.Resource;

public class NamedApiResource<T extends Resource> {

	private String name;
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
