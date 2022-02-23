package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Contato> contatoCli1 = new ArrayList<>();
        ArrayList<Endereco> enderecoCli1 = new ArrayList<>();
        contatoCli1.add(new Contato(1,"WhatsApp","99878145"));
        enderecoCli1.add(new Endereco(1, "Rua João de Barro", 10, "Fundos", "94070-987", "Gravataí", "RS", "Brasil"));
        Cliente cli1 = new Cliente("Gabriel", 1234-10, contatoCli1, enderecoCli1);
        ContaCorrente cc1 = new ContaCorrente(cli1, "1001","0001",300,200);
        ContaPagamento cpag1 = new ContaPagamento(cli1, "3001", "1001", 500);

        ArrayList<Contato> contatoCli2 = new ArrayList<>();
        ArrayList<Endereco> enderecoCli2 = new ArrayList<>();
        contatoCli2.add(new Contato(2,"Empresa","34529715"));
        enderecoCli2.add(new Endereco(2, "Rua Pardal", 20, "Sala 205", "97020-040", "Porto Alegre", "RS", "Brasil"));
        Cliente cli2 = new Cliente("Maicon", 2345-14, contatoCli2, enderecoCli2);
        ContaPoupanca cp1 = new ContaPoupanca(cli2, "2001","0001",500);


//        //CONTATOS E ENDEREÇOS
//        cli1.imprimirContatos();
//        System.out.println();
//        cli1.imprimirEnderecos();
//
//        cli2.imprimirContatos();
//        System.out.println();
//        cli2.imprimirEnderecos();
//
//
//        //IMPRIMIR
//        cc1.imprimir();
//        System.out.println();
//        cp1.imprimir();
//        System.out.println();
//
//        //MÉTODOS DA CONTA CORRENTE
//        cc1.retornarSaldoComChequeEspecial();
//        System.out.println();
//        cc1.setChequeEspecial(50);
//        System.out.println(cc1.getChequeEspecial());
//        System.out.println();
//        cc1.sacar(345);
//
//        //MÉTODOS DA CONTA POUPANÇA
//        cp1.creditarTaxa();
//
//        //TRANSFERÊNCIA
//        cc1.transferir(cpag1, 250);
//
//
//        //MOVIMENTAÇÕES
//        cc1.sacar(200);
//        cp1.sacar(100);
//        cpag1.sacar(497);
//        cc1.depositar(200);
//        cp1.depositar(150);
//        cpag1.depositar(100);

    }
}