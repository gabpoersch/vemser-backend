package com.company;

public class Contato {
    private int tipo;
    private String descricao;
    private String telefone;

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Contato(int tipo, String descricao, String telefone) {
        this.setTipo(tipo);
        this.setDescricao(descricao);
        this.setTelefone(telefone);
    }

    public void imprimirContato() {
        if (getTipo() == 1) {
            System.out.println("(Residencial) "+getDescricao()+": "+getTelefone());
        }
        else if (getTipo() == 2) {
            System.out.println("(Comercial) "+getDescricao()+": "+getTelefone());
        }
        else {
            System.out.println("Tipo inválido.");
        }
    }
}