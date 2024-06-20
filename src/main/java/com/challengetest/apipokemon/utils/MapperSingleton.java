package com.challengetest.apipokemon.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MapperSingleton {

    private static final ObjectMapper objectMapper;

    private MapperSingleton() {}

    static {
        try {
            objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, Boolean.FALSE);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static ObjectMapper instance() {
        return objectMapper;
    }
}
