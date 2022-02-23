package com.company;
import java.util.*;

public class Exercicio03 {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<String>();
        Queue<String> atendidos = new LinkedList<String>();
        int tamanhoFila = 0;

        for (int i = 0; i < 5; i++) {
            fila.add("Senha " + (i + 1));
            tamanhoFila++;
        }

        //Fila completa
        System.out.println("Fila: "+fila);
        System.out.println();

        //Atender 2 pessoas
        for (int i = 0; i < 2; i++) {
            fila.remove();
            atendidos.add("Senha " + (i + 1));
        }
        System.out.println("Atendidos: "+atendidos);
        System.out.println("Fila: "+fila);
        System.out.println();


        //Atender 1 pessoa
        for (int i = 0; i < 1; i++) {
            fila.remove();
            atendidos.add("Senha " + (atendidos.size() + 1));
        }
        System.out.println("Atendidos: "+atendidos);
        System.out.println("Fila: "+fila);
        System.out.println();

        //Adicionar 3 pessoas à fila
        for (int j = 0; j < 3; j++) {
            fila.add("Senha " + (1 + atendidos.size() + fila.size()));
            tamanhoFila++;
        }
        System.out.println("Fila: "+fila);
        System.out.println();

        //Atender 1 pessoa
        for (int i = 0; i < 1; i++) {
            fila.remove();
            atendidos.add("Senha " + (atendidos.size() + 1));
        }
        System.out.println("Atendidos: "+atendidos);
        System.out.println("Fila: "+fila);
        System.out.println("Atendimentos do dia: "+tamanhoFila);







    }
}
