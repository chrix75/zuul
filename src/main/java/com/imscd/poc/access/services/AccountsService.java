package com.imscd.poc.access.services;

/**
 * Created by csperandio on 15/07/2016.
 */
public interface AccountsService {
    public boolean checkAccount(String login, String password);
    public boolean checkApiKey(String apiKey);
}
