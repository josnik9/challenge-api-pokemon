package com.challengetest.apipokemon.api.v1.persistence.repositories;

import com.challengetest.apipokemon.api.v1.persistence.entities.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<RequestEntity, Long> {
}
