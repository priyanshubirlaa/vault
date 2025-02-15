FROM hashicorp/vault:latest

# Expose Vault API port
EXPOSE 8200

# Set Vault to run in non-privileged mode
ENV VAULT_DEV_ROOT_TOKEN_ID="myroot"
ENV VAULT_ADDR="http://0.0.0.0:8200"

# Start Vault in dev mode (no privileges required)
CMD ["vault", "server", "-dev", "-dev-listen-address=0.0.0.0:8200", "-log-level=debug"]
