package com.company;
import java.util.*;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> pessoasCPF = new HashMap<>();
        String[] cpf = {"100", "101"};
        String[] nome = {"Gabriel", "Maicon"};

        for (int i=0;i<cpf.length;i++) {
            pessoasCPF.put(cpf[i], nome[i]);
        }



        System.out.println("Pesquise pelo CPF da pessoa: ");
        String acharCPF = scan.nextLine();


        //Funcionou, mas tá imprimindo às vezes "inválido" com o segundo CPF
        //Quando for corrigir consegue me mandar um áudio pra eu entender? Vou estar no médico e corrijo quando chegar
        for (String s : cpf) {
            if (!Objects.equals(acharCPF, s)) {
                System.out.println("Inválido");
            }
            if (Objects.equals(acharCPF, s)) {
                System.out.println(pessoasCPF.get(acharCPF));
                break;
            }
        }

        System.out.println();
        System.out.println(pessoasCPF);
    }
}
