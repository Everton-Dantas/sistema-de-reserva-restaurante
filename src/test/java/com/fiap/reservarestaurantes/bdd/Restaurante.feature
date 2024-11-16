
Feature: Cadastro de Restaurantes

  Scenario: Restaurante é cadastrado com sucesso
    Given existe um restaurante com os seguintes dados:
      | nome            | localizacao      | tipoCozinha | horarioFuncionamento | capacidade |
      | Restaurante A   | Rua Teste 123    | Italiana    | 10:00-22:00          | 50         |
    When eu envio uma requisição para cadastrar este restaurante
    Then o restaurante é salvo no sistema com sucesso

  Scenario: Cadastro de restaurante falha por falta de nome
    Given existe um restaurante com os seguintes dados:
      | nome | localizacao      | tipoCozinha | horarioFuncionamento | capacidade |
      |      | Rua Sem Nome 456 | Japonesa    | 11:00-20:00          | 30         |
    When eu envio uma requisição para cadastrar este restaurante
    Then o sistema retorna um erro indicando que o nome é obrigatório
