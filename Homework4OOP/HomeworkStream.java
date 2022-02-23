package com.dbc.aula6;

import java.util.*;
import java.util.stream.Collectors;

public class HomeworkStream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
        lista.forEach(System.out::println);
        System.out.println();

        //2- filtrar todas as pessoas com salario maior do que 5 mil
        List<Pessoa> maisQue5 = lista.stream()
                .filter(pessoa -> pessoa.getSalario() > 5000).toList();

        System.out.println("2 - Salário > 5k: "+maisQue5);
        System.out.println();

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente
        List<Pessoa> soDevsOrdemCrescSalario = lista.stream()
                .filter(pessoa -> pessoa.getCargo().contains("Desenvolv"))
                .sorted(Comparator.comparing(Pessoa::getSalario)).toList();
        System.out.println("3 - Devs ordem salário: "+soDevsOrdemCrescSalario);
        System.out.println();


        //4- fazer a média salarial de todos
        double mediaSalario = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();

        System.out.println("4 - Média salarial: "+mediaSalario);
        System.out.println();

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        boolean maisQue20 = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() > 20000);

        System.out.println("5 - Salário > 20k: "+maisQue20);
        System.out.println();

        //6 - retornar uma lista de todos os ids das pessoas
        List<Integer> idsDasPessoas = lista.stream()
                .map(Pessoa::getId)
                .collect(Collectors.toList());
        System.out.println("6 - ID de todos: "+idsDasPessoas);
        System.out.println();

        //7 - criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        List<Salario> listaSalario = lista.stream()
                .map(pessoa -> new Salario(pessoa.getId(), pessoa.getSalario())).toList();
        System.out.println("7 - ID e salário: "+listaSalario);
        System.out.println();

        //8- retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores
        Map<Integer, String> mapIdNome = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println("8 - Mapa ID+Nome: "+mapIdNome);
        System.out.println();

        //9- com o mapa da questão 8, retornar o nome com o id=2
        String value = mapIdNome.get(2);
        System.out.println("9 - Nome ID 2: "+value);
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", salario=" + salario +
                    ", cargo='" + cargo + '\'' +
                    '}';
        }
    }
}
