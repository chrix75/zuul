package com.imscd.poc.access.repositories;

import com.imscd.poc.access.domain.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by csperandio on 15/07/2016.
 */
public class FakeAccountsRepo implements AccountsRepo{
    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public void addAccount(Account account) {
        accounts.put(account.getLogin(), account);
    }

    @Override
    public Optional<Account> fetchAccount(String login) {
        return Optional.ofNullable(accounts.get(login));
    }
}
