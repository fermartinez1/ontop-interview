package com.ontop.martinez.interview.wallet.infrastructure.output.rest.clients;

import com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.response.WalletBalanceDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class WalletClient {

    public WalletBalanceDTO getBalance(Long userId) {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> vars = new HashMap<>();
        vars.put("user_id", userId.toString());

        return restTemplate.getForObject("http://mockoon.tools.getontop.com:3000/wallets/balance?user_id={user_id}",
                WalletBalanceDTO.class, vars);
    }
}
