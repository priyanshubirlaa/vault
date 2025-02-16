package com.spring.vaidya.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.support.VaultResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class JwtSecretController {

    @Autowired
    private VaultTemplate vaultTemplate;

    /**
     * Fetches JWT Secret from HashiCorp Vault
     */
    @GetMapping("/jwt-secret")
    public ResponseEntity<?> getJwtSecret() {
        try {
            // Fetch secret from Vault
            VaultResponse response = vaultTemplate
                    .opsForKeyValue("admin/kv", KeyValueBackend.KV_2)
                    .get("SPRING");

            // Check if response is valid
            if (response != null && response.getData() != null) {
                Map<String, Object> secretData = response.getData();
                String jwtSecret = (String) secretData.get("JWT");

                // Return JWT secret as JSON response
                return ResponseEntity.ok(Map.of("jwtSecret", jwtSecret));
            } else {
                return ResponseEntity.status(404).body(Map.of("error", "JWT secret not found in Vault"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Failed to fetch JWT secret", "message", e.getMessage()));
        }
    }
}

