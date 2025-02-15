FROM hashicorp/vault:latest
EXPOSE 8200
CMD ["vault", "server", "-dev", "-dev-root-token-id=root"]
