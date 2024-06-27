package org.example;

public class Credito extends Conta {

    private double saldoDevedor;

    public Credito(double saldoInicial) {
        super(saldoInicial);
        this.saldoDevedor = 0.0;
    }

    public Credito() {

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

    public void pagarFatura(double valorPagamento) {
        if (valorPagamento >= saldoDevedor) {
            saldoDevedor = 0.00;
            System.out.println("Pagamento efetuado com sucesso! Cartão quitado.");
        } else {
            saldoDevedor -= valorPagamento;
            System.out.println("Pagamento de R$" + valorPagamento + " efetuado. Saldo devedor atual: R$" + saldoDevedor);
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Cartão de Crédito ===");
        super.imprimirExtrato();
        System.out.printf("Saldo Devedor: %.2f%n", this.saldoDevedor);
    }

    public void setCliente(Cliente cliente1) {
    }
}
