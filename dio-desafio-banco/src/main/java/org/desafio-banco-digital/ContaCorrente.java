package org.example;

public class ContaCorrente extends Conta {

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    public ContaCorrente(Cliente cliente1) {
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) throws SaldoInsuficienteException {
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
    }
}
