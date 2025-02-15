FROM hashicorp/vault:latest

# Create a non-root user
RUN addgroup --system vault && adduser --system --ingroup vault vault

# Set permissions and switch to the vault user
USER vault

# Expose the Vault port
EXPOSE 8200

# Start Vault in dev mode with no capabilities needed
CMD ["vault", "server", "-dev", "-dev-listen-address=0.0.0.0:8200", "-dev-root-token-id=root"]
