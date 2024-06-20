package com.challengetest.apipokemon.api.v1.domains;

import java.util.Date;

public interface Request {

    String getId();
    String getIp();
    Date getDate();
    String getActionName();

    boolean isDeleted();
    long getCreatedAt();
    long getUpdatedAt();
}
