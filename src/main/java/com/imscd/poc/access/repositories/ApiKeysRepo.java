package com.imscd.poc.access.repositories;

/**
 * Created by csperandio on 15/07/2016.
 */
public interface ApiKeysRepo {
    public void addApiKey(String apiKey);

    public boolean isKnownApiKey(String apiKey);
}
