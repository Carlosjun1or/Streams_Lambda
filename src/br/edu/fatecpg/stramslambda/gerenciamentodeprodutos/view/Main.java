package br.edu.fatecpg.stramslambda.gerenciamentodeprodutos.view;

import br.edu.fatecpg.stramslambda.gerenciamentodeprodutos.controller.ProdutosController;
import br.edu.fatecpg.stramslambda.gerenciamentodeprodutos.model.Produto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutosController controller = new ProdutosController();

        int op;

        do {
            System.out.println("\nGerenciador de Produtos:");
            System.out.println("1. Adicionar Produto.");
            System.out.println("2. Remover Produto.");
            System.out.println("3. Filtrar Produtos.");
            System.out.println("4. Aplicar Desconto.");
            System.out.println("5. Ver Produtos Cadastrados.");
            System.out.println("6. Total e Media de Preco por Categoria.");
            System.out.println("7. Sair.");

            System.out.print("Escolha uma opcao: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Categoria do produto: ");
                    String categoria = scanner.nextLine();

                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    Produto produto = new Produto(nome, categoria, preco);

                    controller.addProduto(produto);

                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do produto: ");
                    nome = scanner.nextLine();

                    controller.removerProduto(nome);

                    System.out.println("Produto removido, caso estivesse cadastrado.");
                    break;

                case 3:
                    System.out.print("Digite a categoria que deseja filtrar: ");
                    categoria = scanner.nextLine();

                    controller.filtraCategoria(categoria);
                    break;

                case 4:
                    System.out.print("Digite a categoria para aplicar desconto de 10%: ");
                    categoria = scanner.nextLine();

                    List<Produto> produtosComDesconto =
                            controller.aplicarDesconto(categoria);

                    System.out.println("\nProdutos com desconto:");

                    produtosComDesconto.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("\nLista de Produtos Cadastrados:");

                    List<Produto> produtosOrdenados =
                            controller.ordenarPorPreco();

                    produtosOrdenados.forEach(System.out::println);
                    break;

                case 6:
                    Map<String, Double> totais =
                            controller.calcularTotalPorCategoria();

                    System.out.println("\nTotal de preco por categoria:");

                    totais.forEach((cat, total) ->
                            System.out.println(cat + ": R$ " + total)
                    );

                    Map<String, Double> medias =
                            controller.calcularMediaPorCategoria();

                    System.out.println("\nMedia de preco por categoria:");

                    medias.forEach((cat, media) ->
                            System.out.println(cat + ": R$ " + media)
                    );

                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (op != 7);

        scanner.close();
    }
}
