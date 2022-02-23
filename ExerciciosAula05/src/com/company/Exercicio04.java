package com.company;
import java.util.*;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();
        int[] valores = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        for (int i=0;i<valores.length;i++) {
            if (valores[i] % 2 == 0) {
                pilha.add(i);
            }
            else {
                pilha.pop();
            }
        }

        System.out.println(pilha);
    }
}
