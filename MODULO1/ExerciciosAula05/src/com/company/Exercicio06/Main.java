package com.company.Exercicio06;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Aurélio", 25));
        pessoas.add(new Pessoa("Aurélio", 17));
        pessoas.add(new Pessoa("Aurélio", 80));
        pessoas.add(new Pessoa("Whindersson", 67));
        pessoas.add(new Pessoa("Aurélio", 34));
        pessoas.add(new Pessoa("Jeferson", 36));
        pessoas.add(new Pessoa("Maria", 55));
        pessoas.add(new Pessoa("Carla", 41));
        pessoas.add(new Pessoa("Katy", 19));
        pessoas.add(new Pessoa("Nicole", 105));


        //1o comparador
        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        System.out.println(pessoas);
        System.out.println();


        //2o comparador
        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o2.getIdade() - o1.getIdade();
            }
        });
        System.out.println(pessoas);
        System.out.println();


        //3o comparador
        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                int checkName = o1.getNome().compareTo(o2.getNome());
                if (checkName == 0) {
                    return o1.getIdade() - o2.getIdade();
                }
                else {
                    return checkName;
                }
            }
        });
        System.out.println(pessoas);
    }
}