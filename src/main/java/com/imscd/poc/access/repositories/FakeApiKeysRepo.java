package com.imscd.poc.access.repositories;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csperandio on 15/07/2016.
 */
public class FakeApiKeysRepo implements ApiKeysRepo {
    private Set<String> apiKeys = new HashSet<>();

    @Override
    public void addApiKey(String apiKey) {
        apiKeys.add(apiKey);
    }

    @Override
    public boolean isKnownApiKey(String apiKey) {
        return apiKeys.contains(apiKey);
    }
}
