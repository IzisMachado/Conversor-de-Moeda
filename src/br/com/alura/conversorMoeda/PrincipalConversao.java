package br.com.alura.conversorMoeda;

import java.io.IOException;
import java.util.Scanner;

public class PrincipalConversao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorApp conversorApp = new ConversorApp();

        int opcao = 0;

        while (opcao != 11) {
            System.out.println("********************************************");
            System.out.println("Conversor de Moedas = ");
            System.out.println();
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Dólar =>> Euro");
            System.out.println("8) Euro =>> Dólar");
            System.out.println("9) Dólar =>> Libra");
            System.out.println("10) Libra =>> Dólar");
            System.out.println("11) Sair");
            System.out.print("Escolha uma opção válida: ");
            System.out.println("********************************************");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao >= 1 && opcao <= 10) {
                    System.out.print("Digite o valor a ser convertido: ");
                    double valor = Double.parseDouble(scanner.nextLine());

                    String origem = "";
                    String destino = "";

                    switch (opcao) {
                        case 1 -> { origem = "USD"; destino = "ARS"; }
                        case 2 -> { origem = "ARS"; destino = "USD"; }
                        case 3 -> { origem = "USD"; destino = "BRL"; }
                        case 4 -> { origem = "BRL"; destino = "USD"; }
                        case 5 -> { origem = "USD"; destino = "COP"; }
                        case 6 -> { origem = "COP"; destino = "USD"; }
                        case 7 -> { origem = "USD"; destino = "EUR"; }
                        case 8 -> { origem = "EUR"; destino = "USD"; }
                        case 9 -> { origem = "USD"; destino = "GBP"; }
                        case 10 -> { origem = "GBP"; destino = "USD"; }
                    }

                    double resultado = conversorApp.converter(origem, destino, valor);
                    System.out.printf("Resultado: %.2f %s = 💰 %.2f %s\n\n", valor, origem, resultado, destino);

                } else if (opcao == 11) {
                    System.out.println("Obrigado por usar!");
                } else {
                    System.out.println("Opção inválida. Tente novamente.\n");
                }
            } catch (IOException e) {
                System.out.println("Erro ao acessar o serviço de conversão: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido.\n");
            }
        }

        scanner.close();
    }
}