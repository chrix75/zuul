package com.imscd.poc.access.services;

import com.imscd.poc.access.domain.Account;
import com.imscd.poc.access.repositories.AccountsRepo;
import com.imscd.poc.access.repositories.ApiKeysRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by csperandio on 15/07/2016.
 */
@Component
public class FakeAccountsService implements AccountsService {
    private static Logger logger = LoggerFactory.getLogger(FakeAccountsService.class);

    private AccountsRepo accountsRepo;
    private ApiKeysRepo apiKeysRepo;

    public FakeAccountsService(AccountsRepo accountsRepo, ApiKeysRepo apiKeysRepo) {
        this.accountsRepo = accountsRepo;
        this.apiKeysRepo = apiKeysRepo;
    }

    @Override
    public boolean checkAccount(String login, String password) {
        Optional<Account> account = accountsRepo.fetchAccount(login);
        if (account.isPresent()) {
            return account.get().isCorrectPassword(password);
        } else {
            return false;
        }
    }

    @Override
    public boolean checkApiKey(String apiKey) {
        return apiKeysRepo.isKnownApiKey(apiKey);
    }

    @PostConstruct
    public void init() {
        logger.info("Initializing with fake accounts...");

        accountsRepo.addAccount(
                new Account("marley", "reggae")
        );

        accountsRepo.addAccount(
                new Account("batman", "robin")
        );

        apiKeysRepo.addApiKey("4b21f7db-b0a1-47a3-9007-a0547c7104cd");

        // API key for internal services
        apiKeysRepo.addApiKey("a5009daa-803b-455f-9b8f-9c3bf97fc989");

    }
}
