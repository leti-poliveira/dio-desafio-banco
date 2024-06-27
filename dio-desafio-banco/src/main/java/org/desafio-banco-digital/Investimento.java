package org.example;

public class Investimento {

    private final Cliente cliente;
    private final double valorInvestido;

    public Investimento(Cliente cliente, double valorInvestido) {
        this.cliente = cliente;
        this.valorInvestido = valorInvestido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void investir() {
        // Simulate investment logic (can be enhanced)
        System.out.println("Investindo R$" + valorInvestido + " para " + cliente.getNome());

        // Optionally deduct the investment amount from a linked account
        // Conta conta = // Get the linked account (implementation specific)
        // conta.sacar(valorInvestido);
    }
}
