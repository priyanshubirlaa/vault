listener "tcp" {
  address = "0.0.0.0:8200"
  tls_disable = 1
}

api_addr = "https://vault-production-9fbb.up.railway.app:8200"
storage "inmem" {}
