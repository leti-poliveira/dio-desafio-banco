package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Alice");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Bob");

        // Criar contas para os clientes
        ContaCorrente contaCorrente = new ContaCorrente(cliente1);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente2);
        Credito contaCredito = new Credito();
        contaCredito.setCliente(cliente1);

        // Exibir saldo inicial
        System.out.println("Saldo inicial:");
        contaCorrente.imprimirExtrato(); // Método presumido para exibir extrato
        contaPoupanca.imprimirExtrato(); // Método presumido para exibir extrato

        // Realizar algumas operações
        contaCorrente.depositar(1000.0);
        contaPoupanca.depositar(500.0);
        try {
            contaCorrente.transferir(200.0, contaPoupanca);
        } catch (SaldoInsuficienteException e) {
            throw new RuntimeException(e);
        }
        contaCredito.pagarFatura(100.0);

        // Exibir saldo após operações
        System.out.println("\nSaldo após operações:");
        contaCorrente.imprimirExtrato(); // Método presumido para exibir extrato
        contaPoupanca.imprimirExtrato(); // Método presumido para exibir extrato

        // Fechar scanner
        scanner.close();
    }
}

