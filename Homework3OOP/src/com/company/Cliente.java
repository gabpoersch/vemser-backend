package com.company;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private int cpf;
    private ArrayList<Contato> contato;
    private ArrayList<Endereco> endereco;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContato() {
        return contato;
    }
    public void setContato(ArrayList<Contato> contato) {
        this.contato = contato;
    }

    public ArrayList<Endereco> getEndereco() {
        return endereco;
    }
    public void setEndereco(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
    }

    public Cliente(String nome, int cpf, ArrayList<Contato> contato, ArrayList<Endereco> endereco) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.contato = new ArrayList<>(contato);
        this.endereco = new ArrayList<>(endereco);
    }

    public void imprimirContatos() {
        for (Contato contato:getContato()) {
            contato.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco:getEndereco()) {
            endereco.imprimirEndereco();
        }
    }

    public void imprimirCliente() {
        System.out.println(getNome()+ "\n" +
                "CPF: " +getCpf());
        imprimirEnderecos();
        imprimirContatos();
    }
}
