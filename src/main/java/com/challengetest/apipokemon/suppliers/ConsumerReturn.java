package com.challengetest.apipokemon.suppliers;

@FunctionalInterface
public interface ConsumerReturn<T, R> {

    /**
     * Combines a Supplier and Consumer of Java Util Functions
     * @param t the input argument
     * @return returns a result
     */
    R call(T t);

}
