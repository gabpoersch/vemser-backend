package com.company;

public class Cliente {
    private String nome;
    private int cpf;
    private Contato[] contato = new Contato[2];
    private Endereco[] endereco = new Endereco[2];

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

    public Contato [] getContato() {
        return contato;
    }
    public void setContato(Contato[] contato) {
        this.contato = contato;
    }

    public Endereco[] getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco[] endereco) {
        this.endereco = endereco;
    }

    public Cliente(String nome, int cpf, Contato[] contato, Endereco[] endereco) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setContato(contato);
        this.setEndereco(endereco);
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
