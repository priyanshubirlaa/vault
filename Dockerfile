FROM hashicorp/vault:latest

# Install necessary packages (Alpine-based)
USER root
RUN apk add --no-cache shadow

# Check and create group & user if they don't exist
RUN getent group vault || groupadd vault
RUN getent passwd vault || useradd -g vault -s /bin/false vault

# Set permissions and switch to the vault user
USER vault

# Expose the Vault port
EXPOSE 8200

# Start Vault in dev mode with non-root permissions
CMD ["vault", "server", "-dev", "-dev-listen-address=0.0.0.0:8200", "-dev-root-token-id=root"]
