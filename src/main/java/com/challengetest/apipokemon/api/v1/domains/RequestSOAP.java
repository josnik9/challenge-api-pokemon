package com.challengetest.apipokemon.api.v1.domains;

import com.challengetest.apipokemon.utils.ANConstants;

import java.util.Date;

public class RequestSOAP implements Request {

    private String id;
    private String ip;
    private Date date;
    private String actionName;

    protected boolean deleted;
    protected long createdAt;
    protected long updatedAt;

    public RequestSOAP() {}

    public RequestSOAP(String ip, Date date, String actionName) {
        this.ip = ip;
        this.date = date;
        this.actionName = actionName;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getActionName() {
        return actionName;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public long getUpdatedAt() {
        return updatedAt;
    }

    public RequestSOAP removeSuffix() {
        this.actionName = this.actionName.replace(ANConstants.REQUEST, ANConstants.EMPTY);
        return this;
    }
}
