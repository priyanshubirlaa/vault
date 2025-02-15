FROM hashicorp/vault:latest

# Expose Vault port
EXPOSE 8200

# Start Vault in development mode (not for production)
CMD ["vault", "server", "-config=/app/config.hcl"]

