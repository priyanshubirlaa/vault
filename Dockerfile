FROM hashicorp/vault:latest

# Expose Vault API port
EXPOSE 8200

# Start Vault server in dev mode (for testing)
CMD ["vault", "server", "-dev", "-dev-listen-address=0.0.0.0:8200"]
