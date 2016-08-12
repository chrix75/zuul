package com.imscd.poc.access.repositories;

import com.imscd.poc.access.domain.Account;

import java.util.Optional;

/**
 * Created by csperandio on 15/07/2016.
 */
public interface AccountsRepo {
    void addAccount(Account account);

    Optional<Account> fetchAccount(String login);
}
