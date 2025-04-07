// main.tf
provider "aws" {
  region                      = "us-east-1"
  access_key                  = "mock_access_key"
  secret_key                  = "mock_secret_key"
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  s3_force_path_style         = true
  endpoints {
    dynamodb = "http://localhost:4566"
  }
}

resource "aws_dynamodb_table" "clientes" {
  name           = "clientes"
  billing_mode   = "PAY_PER_REQUEST"
  hash_key       = "id"

  attribute {
    name = "id"
    type = "N"
  }

  attribute {
    name = "nome"
    type = "S"
  }

  attribute {
    name = "email"
    type = "S"
  }

  attribute {
    name = "telefone"
    type = "S"
  }

  attribute {
    name = "cpf"
    type = "S"
  }

  attribute {
    name = "senha"
    type = "S"
  }

  attribute {
    name = "usuario"
    type = "S"
  }
}