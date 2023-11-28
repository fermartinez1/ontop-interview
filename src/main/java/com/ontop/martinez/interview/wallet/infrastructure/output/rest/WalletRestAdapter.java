package com.ontop.martinez.interview.wallet.infrastructure.output.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontop.martinez.interview.wallet.application.ports.output.WalletOutputPort;
import com.ontop.martinez.interview.wallet.domain.exception.WalletTransactionException;
import com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.request.WalletTransactionRequestDTO;
import com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.response.WalletBalanceDTO;
import com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.response.WalletTransactionResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@Component
@Slf4j
public class WalletRestAdapter implements WalletOutputPort {

    @Override
    public Long createWalletTransaction(Long userId, BigDecimal amount) {

        try {
            WalletTransactionRequestDTO walletTransactionRequestDTO = WalletTransactionRequestDTO
                    .builder()
                    .amount(amount)
                    .userId(userId)
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<WalletTransactionRequestDTO> requestEntity
                    = new HttpEntity<>(walletTransactionRequestDTO, headers);
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI("http://mockoon.tools.getontop.com:3000/wallets/transactions");

            ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                ObjectMapper mapper = new ObjectMapper();
                WalletTransactionResponseDTO walletTransactionResponseDTO = mapper.readValue(responseEntity.getBody(), WalletTransactionResponseDTO.class);
                log.info("Wallet transaction succeeded with id: " + walletTransactionResponseDTO.getWalletTransactionId());
                return walletTransactionResponseDTO.getWalletTransactionId();
            } else {
                throw new WalletTransactionException("Error processing wallet transaction");
            }
        } catch (Exception ex) {
            throw new WalletTransactionException(ex.getMessage());
        }
    }

    @Override
    public BigDecimal getWalletBalance(Long userId) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> vars = new HashMap<>();
        vars.put("user_id", userId.toString());

        WalletBalanceDTO response = restTemplate.getForObject("http://mockoon.tools.getontop.com:3000/wallets/balance?user_id={user_id}",
                WalletBalanceDTO.class, vars);

        return response.getBalance();
    }
}
