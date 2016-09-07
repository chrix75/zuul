package com.imscd.poc.access.controllers;

import com.imscd.poc.access.exceptions.BadCredentials;
import com.imscd.poc.access.services.AccountsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imscd.poc.security.JWTManager;

import java.util.Map;

/**
 * Created by csperandio on 15/07/2016.
 */
@RestController
public class AccessController {
    private static Logger logger = LoggerFactory.getLogger(AccessController.class);

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private JWTManager jwtManager;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, String> register(@RequestParam(value = "login") String login,
                          @RequestHeader(value = "Authorization") String apiKey) {

        if (accountsService.checkApiKey(apiKey)) {
            return jwtManager.buildToken(apiKey, login);
        } else {
            logger.error("Invalid API key.");
            throw new BadCredentials(String.format("Bad credentials for the user %s", login));
        }
    }

    /**
     * Generates a JWT with no time limit.
     * @param login
     * @param apiKey
     * @return
     */

    @RequestMapping(value = "/fulltime", method = RequestMethod.POST)
    public Map<String, String> fulltime(@RequestParam(value = "login") String login,
                          @RequestHeader(value = "Authorization") String apiKey) {

        //comment
        if (accountsService.checkApiKey(apiKey)) {
            return jwtManager.buildFullTimeToken(apiKey, login);
        } else {
            logger.error("Invalid API key.");
            throw new BadCredentials(String.format("Bad credentials for the user %s", login));
        }
    }

    @RequestMapping(value = "/signin", method = {RequestMethod.POST})
    public Map<String, String> confirmAccess(@RequestParam(value = "login") String login,
                               @RequestParam(value = "pwd") String password,
                               @RequestHeader(value = "Authorization") String apiKey) {

        logger.info("Trying a connection for the user: " + login);
        logger.info("Current API key: " + apiKey);

        if (accountsService.checkApiKey(apiKey) && accountsService.checkAccount(login, password)) {
            logger.info(String.format("The user %s is well connected", login));
            logger.info("Generating the JWT...");

            return jwtManager.buildToken(apiKey, login);
        } else {
            logger.error(String.format("Bad credentials for the user %s", login));
            throw new BadCredentials(String.format("Bad credentials for the user %s", login));
        }
    }

}
