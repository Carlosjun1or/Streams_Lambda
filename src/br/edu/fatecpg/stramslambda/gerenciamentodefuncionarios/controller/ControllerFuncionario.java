package br.edu.fatecpg.stramslambda.gerenciamentodefuncionarios.controller;


import br.edu.fatecpg.stramslambda.gerenciamentodefuncionarios.model.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerFuncionario {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public ControllerFuncionario() {
        funcionarios.add(new Funcionario("Ana", "TI", 4500, 12));
        funcionarios.add(new Funcionario("Bruno", "RH", 3200, 5));
        funcionarios.add(new Funcionario("Carolina", "Financeiro", 5500, 15));
        funcionarios.add(new Funcionario("Daniel", "TI", 2800, 3));
        funcionarios.add(new Funcionario("Eduarda", "RH", 3900, 11));
        funcionarios.add(new Funcionario("Felipe", "Financeiro", 2500, 2));
        funcionarios.add(new Funcionario("Gabriela", "TI", 6000, 20));
        funcionarios.add(new Funcionario("Henrique", "Financeiro", 4100, 8));
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public List<Funcionario> filtrarPorSalario(double valor) {

        return funcionarios.stream().filter(f -> f.getSalario() > valor).collect(Collectors.toList());
    }

    public List<Funcionario> aplicarAumento() {

        return funcionarios.stream().map(f -> {

            double salario = f.getSalario();

            if (f.getAnosDeServico() > 10) {
                salario = salario * 1.05;
            }

            return new Funcionario(f.getNome(), f.getDepartamento(), salario, f.getAnosDeServico());
        }).collect(Collectors.toList());
    }

    public List<Funcionario> ordenarPorNome() {
        return funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).collect(Collectors.toList());
    }

    public double calcularTotalSalarios() {

        return funcionarios.stream().map(Funcionario::getSalario).reduce(0.0, Double::sum);
    }

    public Map<String, Double> calcularMediaPorDepartamento() {

        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getDepartamento, Collectors.averagingDouble(Funcionario::getSalario)));
    }
}