package com.company;

public class Contato {
    int tipo;
    String descricao;
    String telefone;

    public Contato(String descricao, String telefone, int tipo) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.telefone = telefone;
    }

    public void imprimirContato() {
        if (tipo == 1) {
            String res = "Residencial";
            System.out.println("("+res+") "+descricao+": "+telefone);
        }
        if (tipo == 2) {
            String com = "Comercial";
            System.out.println("("+com+") "+descricao+": "+telefone);
        }
    }

}
