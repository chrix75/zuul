package com.imscd.poc;

import com.imscd.poc.access.repositories.AccountsRepo;
import com.imscd.poc.access.repositories.ApiKeysRepo;
import com.imscd.poc.access.repositories.FakeAccountsRepo;
import com.imscd.poc.access.repositories.FakeApiKeysRepo;
import com.imscd.poc.access.services.AccountsService;
import com.imscd.poc.access.services.FakeAccountsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.imscd.poc.security.BasicJWTManager;
import com.imscd.poc.security.JWTManager;

/**
 * Created by csperandio on 15/07/2016.
 */
@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public AccountsRepo fakeAccountsRepo() {
        return new FakeAccountsRepo();
    }

    @Bean
    @Profile("dev")
    public ApiKeysRepo fakeApiKeysRepo() {
        return new FakeApiKeysRepo();
    }

    @Bean
    @Profile("dev")
    public AccountsService fakeAccountsService(AccountsRepo accountsRepo, ApiKeysRepo apiKeysRepo) {
        return new FakeAccountsService(accountsRepo, apiKeysRepo);
    }

    @Bean
    @Profile("dev")
    public JWTManager jwtManager() { return new BasicJWTManager(); }


}

