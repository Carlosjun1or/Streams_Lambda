package br.edu.fatecpg.stramslambda.gerenciamentodeprodutos.model;

public class Produto {
    private String nomeProduto;
    private String categoriaProduto;
    private double precoProduto;

    public Produto(String nomeProduto, String categoriaProduto, double precoProduto) {
        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.precoProduto = precoProduto;
    }

    public String getNome() {
        return nomeProduto;
    }

    public void setNome(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoria() {
        return categoriaProduto;
    }

    public void setCategoria(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public double getPreco() {
        return precoProduto;
    }

    public void setPreco(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nomeProduto + '\'' +
                ", categoria='" + categoriaProduto + '\'' +
                ", preco=" + precoProduto +
                '}';
    }
}

