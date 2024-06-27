package org.example;

public abstract class Conta {
    protected double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public Conta() {
        this.saldo = 0.0;
    }

    public abstract void sacar(double valor) throws SaldoInsuficienteException;

    public abstract void transferir(double valor, Conta contaDestino) throws SaldoInsuficienteException;

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void imprimirExtrato() {
        System.out.println("Saldo atual: R$" + saldo);
    }
}
