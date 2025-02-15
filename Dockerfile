FROM vault:latest

# Expose Vault port
EXPOSE 8200

# Set Vault to development mode (for testing purposes)
CMD ["vault", "server", "-dev", "-dev-root-token-id=root"]
