package com.spring.vaidya.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.vaidya.vaultService.VaultService;

@RestController
@RequestMapping("/api/vault")
public class VaultController {

    private final VaultService vaultService;

    public VaultController(VaultService vaultService) {
        this.vaultService = vaultService;
    }

    @GetMapping("/secret")
    public ResponseEntity<String> getSecret() {
        return ResponseEntity.ok(vaultService.fetchSecret());
    }
}
