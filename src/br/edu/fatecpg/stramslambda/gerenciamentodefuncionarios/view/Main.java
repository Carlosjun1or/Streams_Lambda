package br.edu.fatecpg.stramslambda.gerenciamentodefuncionarios.view;

import br.edu.fatecpg.stramslambda.gerenciamentodefuncionarios.controller.ControllerFuncionario;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControllerFuncionario controller = new ControllerFuncionario();
        int opcao;

        do {
            System.out.println("\n===== FUNCIONÁRIOS =====");
            System.out.println("1 - Listar funcionários");
            System.out.println("2 - Filtrar salário superior a R$ 3000");
            System.out.println("3 - Aplicar aumento de 5%");
            System.out.println("4 - Ordenar por nome");
            System.out.println("5 - Calcular total dos salários");
            System.out.println("6 - Média salarial por departamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    controller.listarFuncionarios().forEach(System.out::println);
                    break;

                case 2:
                    controller.filtrarPorSalario(3000).forEach(System.out::println);
                    break;

                case 3:
                    controller.aplicarAumento().forEach(System.out::println);
                    break;

                case 4:
                    controller.ordenarPorNome().forEach(System.out::println);
                    break;

                case 5:
                    double total = controller.calcularTotalSalarios();

                    System.out.printf("Total dos salários: R$ %.2f%n", total);
                    break;

                case 6:
                    Map<String, Double> medias = controller.calcularMediaPorDepartamento();

                    medias.forEach((departamento, media) -> System.out.printf("%s: R$ %.2f%n", departamento, media));
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}