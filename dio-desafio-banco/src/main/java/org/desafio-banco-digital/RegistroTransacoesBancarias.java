package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroTransacoesBancarias { public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Lê a Entrada que informa o saldo inicial da conta
    double saldo = 0.0;
    boolean saldoValido = false;
    while (!saldoValido) {
        try {
            System.out.print("Informe o saldo inicial da conta: ");
            saldo = scanner.nextDouble();
            saldoValido = true;
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, insira um valor numérico.");
            scanner.nextLine(); // Limpar o buffer do scanner
        }
    }

    // Lê a Entrada com a quantidade total de transações
    int quantidadeTransacoes = 0;
    boolean quantidadeValida = false;
    while (!quantidadeValida) {
        try {
            System.out.print("Informe a quantidade total de transações: ");
            quantidadeTransacoes = scanner.nextInt();
            quantidadeValida = true;
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            scanner.nextLine(); // Limpar o buffer do scanner
        }
    }

    // Lista para armazenar as transações
    List<String> transacoes = new ArrayList<>();

    // Loop para iterar sobre as transações
    for (int i = 1; i <= quantidadeTransacoes; i++) {
        // Lê a Entrada com o tipo de transação (D para depósito ou S para saque)
        char tipoTransacao = ' ';
        boolean tipoValido = false;
        while (!tipoValido) {
            try {
                System.out.print("Tipo de transação (D para depósito, S para saque): ");
                tipoTransacao = scanner.next().toUpperCase().charAt(0);
                if (tipoTransacao == 'D' || tipoTransacao == 'S') {
                    tipoValido = true;
                } else {
                    System.out.println("Opção inválida. Utilize D para depósito ou S para saque.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira D ou S.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        // Lê a Entrada com o valor da transação
        double valorTransacao = 0.0;
        boolean valorValido = false;
        while (!valorValido) {
            try {
                System.out.print("Valor da transação: ");
                valorTransacao = scanner.nextDouble();
                valorValido = true;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um valor numérico.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        // Atualiza o saldo da conta e adiciona a transação à lista
        if (tipoTransacao == 'D') {
            saldo += valorTransacao;
            transacoes.add("Depósito de " + valorTransacao);
            System.out.println("Depósito de R$" + valorTransacao + " realizado com sucesso.");
        } else if (tipoTransacao == 'S') {
            try {
                if (saldo >= valorTransacao) {
                    saldo -= valorTransacao;
                    transacoes.add("Saque de " + valorTransacao);
                    System.out.println("Saque de R$" + valorTransacao + " realizado com sucesso.");
                } else {
                    throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
                }
            } catch (SaldoInsuficienteException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Fechar o Scanner ao finalizar
    scanner.close();
}
}


