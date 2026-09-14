package br.edu.fatecpg.stramslambda.gerenciamentodeprodutos.controller;

import br.edu.fatecpg.stramslambda.gerenciamentodeprodutos.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProdutosController {
    private List<Produto> produtos;

    public ProdutosController() {
        produtos = new ArrayList<>();

        produtos.add(new Produto("Notebook", "Eletronicos", 2768.99));
        produtos.add(new Produto("Celular", "Eletronicos", 1899.99));
        produtos.add(new Produto("Fone", "Eletronicos", 299.90));
        produtos.add(new Produto("Livro Java", "Livros", 89.90));
        produtos.add(new Produto("Livro Python", "Livros", 79.90));
        produtos.add(new Produto("Camiseta", "Roupas", 59.90));
        produtos.add(new Produto("Calca", "Roupas", 129.90));
        produtos.add(new Produto("Jaqueta", "Roupas", 199.90));

    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(String nome) {
        produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public void filtraCategoria(String categoria) {
        produtos.stream().filter(p -> p.getCategoria().equalsIgnoreCase(categoria)).forEach(System.out::println);
    }


    public List<Produto> aplicarDesconto(String categoria) {
        return produtos.stream().filter(p -> p.getCategoria().equalsIgnoreCase(categoria)).map(p -> new Produto(p.getNome(), p.getCategoria(), p.getPreco() * 0.90)).toList();
    }

    public List<Produto> ordenarPorPreco() {
        return produtos.stream().sorted((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco())).toList();
    }

    public Map<String, Double> calcularTotalPorCategoria() {
        return produtos.stream().collect(Collectors.groupingBy(Produto::getCategoria, Collectors.summingDouble(Produto::getPreco)));
    }

    public Map<String, Double> calcularMediaPorCategoria() {
        return produtos.stream().collect(Collectors.groupingBy(Produto::getCategoria, Collectors.averagingDouble(Produto::getPreco)));
    }
}