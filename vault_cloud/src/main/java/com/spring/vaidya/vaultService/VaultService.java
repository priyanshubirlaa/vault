package com.spring.vaidya.vaultService;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VaultService {

    @Value("${vault.api.url}")
    private String apiUrl;

    @Value("${vault.api.token}")
    private String token;

    private final RestTemplate restTemplate = new RestTemplate();

    public String fetchSecret() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        return response.getBody();  // You can parse this JSON if needed
    }
}
