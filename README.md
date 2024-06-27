# Aplicação Bancária Simples em Java

Este projeto Java simula um sistema bancário básico com funcionalidades como depósito, saque, transferência entre contas e gestão de saldo de uma conta de crédito.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **Cliente**: Representa um cliente do banco com um nome associado.
- **Conta**: Classe abstrata que define o comportamento básico de uma conta bancária, como saldo e operações.
  - **ContaCorrente**: Implementa uma conta corrente com métodos específicos para saque e transferência.
  - **ContaPoupanca**: Implementa uma conta poupança com métodos específicos para saque e transferência.
  - **Credito**: Implementa uma conta de crédito com métodos para pagar faturas e imprimir extrato.
- **Banco**: Representa um banco que contém uma lista de contas.
- **Investimento**: Classe simples que simula um investimento associado a um cliente.
- **Main**: Classe principal que demonstra o uso das classes e funcionalidades principais da aplicação.
- **RegistroTransacoesBancarias**: Classe adicional que simula transações bancárias com entrada do usuário.
- **SaldoInsuficienteException**: Exceção customizada para lidar com tentativas de saque com saldo insuficiente.

## Funcionalidades Implementadas

### Cliente

A classe `Cliente` representa um cliente do banco com um nome associado.

- **Métodos**:
  - `getNome()`: Retorna o nome do cliente.
  - `setNome(String nome)`: Define o nome do cliente.

### Conta

A classe abstrata `Conta` define o contrato básico para contas bancárias.

- **Atributos**:
  - `saldo`: Representa o saldo atual da conta.

- **Métodos**:
  - `sacar(double valor)`: Método abstrato para sacar um valor da conta.
  - `depositar(double valor)`: Adiciona um valor ao saldo da conta.
  - `transferir(double valor, Conta contaDestino)`: Método abstrato para transferir um valor para outra conta.
  - `getSaldo()`: Retorna o saldo atual da conta.
  - `setSaldo(double saldo)`: Define o saldo da conta.
  - `imprimirExtrato()`: Imprime o saldo atual da conta.

### ContaCorrente

A classe `ContaCorrente` é uma implementação específica de `Conta` para contas correntes.

- **Métodos**:
  - `sacar(double valor)`: Implementação específica para saque em conta corrente.
  - `transferir(double valor, Conta contaDestino)`: Implementação específica para transferência entre contas correntes.

### ContaPoupanca

A classe `ContaPoupanca` é uma implementação específica de `Conta` para contas poupança.

- **Métodos**:
  - `sacar(double valor)`: Implementação específica para saque em conta poupança.
  - `transferir(double valor, Conta contaDestino)`: Implementação específica para transferência entre contas poupança.

### Credito

A classe `Credito` é uma implementação específica de `Conta` para contas de crédito.

- **Atributos**:
  - `saldoDevedor`: Representa o saldo devedor da conta de crédito.

- **Métodos**:
  - `sacar(double valor)`: Implementação específica para saque em conta de crédito.
  - `transferir(double valor, Conta contaDestino)`: Implementação específica para transferência de crédito.
  - `pagarFatura(double valorPagamento)`: Método para pagar a fatura da conta de crédito.
  - `imprimirExtrato()`: Imprime o saldo devedor da conta de crédito.
  - `setCliente(Cliente cliente1)`: Define o cliente associado à conta de crédito.

### Banco

A classe `Banco` representa uma entidade bancária que contém uma lista de contas.

- **Atributos**:
  - `nome`: Nome do banco.
  - `contas`: Lista de contas associadas ao banco.

- **Métodos**:
  - `getNome()`: Retorna o nome do banco.
  - `setNome(String nome)`: Define o nome do banco.
  - `getContas()`: Retorna a lista de contas do banco.
  - `setContas(List<Conta> contas)`: Define a lista de contas do banco.

### Main

A classe `Main` demonstra a utilização das classes e funcionalidades principais da aplicação.

- **Método `main(String[] args)`**: Exemplo de execução da aplicação com criação de clientes, contas, operações de depósito, saque, transferência e pagamento de fatura.

### RegistroTransacoesBancarias

A classe `RegistroTransacoesBancarias` simula transações bancárias com entrada do usuário.

- **Método `main(String[] args)`**: Simula interações para informar saldo inicial, quantidade de transações e realizações de depósitos e saques.

### SaldoInsuficienteException

A classe `SaldoInsuficienteException` é uma exceção customizada para lidar com situações de saldo insuficiente em operações de saque.
